package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component("/auth/login")
public class LogoutFormController implements PageController {


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
    request.getSession().invalidate();
    return "redirect:login";
  }
}
