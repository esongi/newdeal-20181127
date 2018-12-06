package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  BoardDao boardDao;

  @Override
  public void init() {
    ApplicationContext iocContainer =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class); // class가 아니라 ~타입이라는 정보를 가져옴!
  };

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(request.getParameter("no"));

      Board board = boardDao.findByNo(no);
      
      request.setAttribute("board", board);
      
      RequestDispatcher rd = request.getRequestDispatcher("/board/detail.jsp");

      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response); 
      
    } catch (Exception e) {
      e.printStackTrace(); //서버
      throw new ServletException(); //웹에 던져줌
    }
  }
}
