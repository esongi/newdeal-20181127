package com.eomcs.lms.web;

import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/auth/login")
public class LoginController implements PageController {

  MemberDao memberDao;

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    try {
      HashMap<String, Object> params = new HashMap<>();
      params.put("email", request.getParameter("email"));
      params.put("password", request.getParameter("password"));
      Member member = memberDao.findByEmailPassword(params);

      // 해당 클라이언트를 위한 HttpSession 객체가 있다면, 그 객체를 리턴한다
      // 없다면, 새로 만들어 리턴한다
      HttpSession session = request.getSession();
      
      if (member != null) {
        session.setAttribute("loginUser", member);
        return "redirect:../board/list";
      } else {
        // 기존의 세션을 모두 무효
        session.invalidate();
        return "redirect:form";
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException();
    }

  }
}
