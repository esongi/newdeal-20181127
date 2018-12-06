package com.eomcs.lms.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

@WebServlet("/lesson/add")
public class LessonAddServlet extends HttpServlet {
  // 강의 추가??

  private static final long serialVersionUID = 1L;
  LessonDao lessonDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer =
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 강사 or 관리자만 개설 가능?? 수업보고 진행

    HttpSession session = request.getSession();

    Member loginUser = (Member) session.getAttribute("loginUser");

    List<Map<String, Object>> lessons;
    try {
      lessons = lessonDao.findByParticipantNo(loginUser.getNo());
      request.setAttribute("lessons", lessons);
    } catch (Exception e) {
      e.printStackTrace();
    }

    RequestDispatcher rd = request.getRequestDispatcher("/lesson/form.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 강사 or 관리자만 개설 가능?? 수업보고 진행

    try {

      Lesson lesson = new Lesson();

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");

      // 강의 번호 어떻게????
      lesson.setNo(Integer.parseInt(request.getParameter("lno")));

      lesson.setTitle(request.getParameter("title"));
      lesson.setContents(request.getParameter("contents"));
      lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));

      // 회원번호 여기선 필요 없을듯??

      lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));

      lessonDao.insert(lesson);

      // 웹브라우저 입장이기에 상대경로(웹브라우저는 현재 경로를 알고있기에
      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();

    }
  }

}
