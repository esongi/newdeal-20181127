package com.eomcs.lms.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// 서블릿을 만들었으면 톰캣 서버에 알려줘야 한다
// => 서블릿에 URL을 부여한다
// => URL은 항상 '/' 로 시작해야 한다
// => 서블릿을 추가했으면 톰캣 서버를 재시작해야 사용할 수 있다
// => 한 번 톰캣 서버에 서블릿을 추가한 후 서블릿을 변경한다면 일정 시간이 지난후에 자동으로 해당
// => 서블릿을 재적재한다. 즉 서버를 재시작할 필요가 없다.
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    // 이 메서드는 서블릿 객체가 최초로 생성될 때 생성자 다음에 바로 호출된다
    // => 원래는 init(ServletConfig)가 먼저 호출되고,
    // => init(SErvletConfig)가 이 init()를 호출한다
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      boardDao = iocContainer.getBean(BoardDao.class);

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException();
    }
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // BoardDao 객체를 꺼내기 위해 먼저 IoC 컨테이너를 꺼낸다
    // 웹 어플리케이션(현:newdeal-project-52) 하나당 서블릿컨텍스트 하나가 있다
    // MIME Type
    // Multi-purpose Mail Extension

    try {
      List<Board> list = boardDao.findAll();

      // 게시물을 목록을 jsp가 사용할 수 있또록 보관소 저장
      request.setAttribute("list", list);

      // jsp로 실행을 위임
      RequestDispatcher rd = request.getRequestDispatcher("/board/list.jsp");

      // 출력 콘텐트의 타입을 include 하는 쪽에서 지정해야 한다
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response); // forward는 안돌아오고, include는 돌아옴

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(); // 웹에 던져줌
    }
  }
}
