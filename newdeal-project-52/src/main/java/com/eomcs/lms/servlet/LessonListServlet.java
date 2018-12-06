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
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  LessonDao lessonDao;

  @Override
  public void init() throws ServletException {
    ServletContext sc = this.getServletContext();
    ApplicationContext iocContainer = (ApplicationContext) sc.getAttribute("iocContainer");

    try {
      lessonDao = iocContainer.getBean(LessonDao.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      List<Lesson> list = lessonDao.findAll();

      // 게시물을 목록을 jsp가 사용할 수 있또록 보관소 저장
      request.setAttribute("list", list);

      // jsp로 실행을 위임
      RequestDispatcher rd = request.getRequestDispatcher("/lesson/list.jsp");

      // 출력 콘텐트의 타입을 include 하는 쪽에서 지정해야 한다
      response.setContentType("text/html;charset=UTF-8");
      rd.include(request, response); // forward는 안돌아오고, include는 돌아옴

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException();

    }
  }

}
