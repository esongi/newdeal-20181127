package com.eomcs.lms.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;

@Component("/board/delete")
public class BoardDeleteController implements PageController {

  BoardDao boardDao;

  public BoardDeleteController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    request.setAttribute("count", boardDao.delete(no));

    RequestDispatcher rd = request.getRequestDispatcher("/board/delete.jsp");

    response.setContentType("text/html;charset=UTF-8");
    rd.include(request, response);

    return "redirect:list";
  }
}
