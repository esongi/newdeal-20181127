package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 프론트 컨트롤러(DispatcherServlet)가 페이지 컨트롤러에서 실행할 때 호출하는 메서드 규칙
// 관리: 서블릿 -> ioc 컨테이너
public interface PageController {
  
  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
