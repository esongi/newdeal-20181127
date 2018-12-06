package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.lms.domain.Member;

@WebFilter("/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpReq = (HttpServletRequest) request;
    HttpServletResponse httpResp = (HttpServletResponse) response;

    String servletPath = httpReq.getServletPath();

    if (!servletPath.startsWith("/auth") && !servletPath.endsWith(".html")
        && !servletPath.endsWith(".css") && !servletPath.endsWith(".js")
        && !servletPath.endsWith(".jpeg") && !servletPath.endsWith(".png")) {
      HttpSession session = httpReq.getSession();
      Member loginUser = (Member) session.getAttribute("loginUser");

      if (loginUser == null) {
        httpResp.sendRedirect("/auth/login");
        return;
      }
    }

    // 이 필터 다음에 또 다른 필터가 있다면 그 필터를 실행한다
    // 없다면 원래 목적지인 서블릿을 실행한다
    chain.doFilter(request, response);
  }
}
