package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  BoardDao boardDao;

  @Override
  public void init() {
    ApplicationContext iocContainer =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class); // class가 아니라 ~타입이라는 정보를 가져옴!
  };

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // POST 요청으로 들어온 데이터는 UTF-8 로 인코딩되어 있다
    // 그런데 request.getparameter()의 리턴값은 unicode(2byte)이다
    // 즉, UTF-8을 JVM이 다루는 Unicode로 변환한 후에 리턴하는 것이다
    // 문제는 클라이언트가 보낸 데이터가 UTF-8로 되어있다고 알려주지 않으면
    // getParameter()는 클라이언트가 보낸 데이터가 ISO-8859-1 이라고 착각을 한다
    // 즉, 영어라고 착각하고 영어를 Unicode로 바꾸는 것이다
    // 그래서 UTF-8로 인코딩 된 한글 데이터가 Unicode로 바뀔 때 깨지는 것이다
    // 해결책?
    // getparameter()를 최초로 호출하기 전에 클라이언트가 보낸 데이터가 UTF-8로 되어 있다고 알려줘야 한다


    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setContents(request.getParameter("contents"));

      boardDao.update(board);

      // 데이터를 변경한 후 웹 브라우저에게 목록 URL을 다시 요청하라고 응답한다(상대경로)
      // 클라이언트는 서블릿을 요청해야 한다!(상대경로o, 파일위치x : ~.jsp)
      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException();
    }
  }
}
