package com.eomcs.lms.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/board")
public class BoardController {

  BoardDao boardDao;
  LessonDao lessonDao;

  public BoardController(BoardDao boardDao, LessonDao lessonDao) {
    this.boardDao = boardDao;
    this.lessonDao = lessonDao;
  }

  @RequestMapping("add")
  public String add(Board board, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    board.setWriterNo(loginUser.getNo());
    boardDao.insert(board);

    return "redirect:list";
  }

  @RequestMapping("delete")
  public void delete(int no, Model model) throws Exception {

    // Model은 스프링 클래스, 빈 그릇! 맵도 가능
    model.addAttribute("count", boardDao.delete(no));
  }

  @RequestMapping("detail")
  public void detail(int no, Model model) throws Exception {

    // int no = Integer.parseInt(request.getParameter("no"));
    // model이 가능한 이유는 request 에 담겨 있기 때문?
    // 왜 HttpRequest를 안쓰고 모델을 쓰는가 >> 다른 데서도 사용하기 위해(tiles)
    Board board = boardDao.findByNo(no);
    model.addAttribute("board", board);
  }

  @RequestMapping("form")
  public void form(Model model, HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    // view resolve가 jsp 가 아닐수도 있기에 model 을 쓴다!!!!
    List<Map<String, Object>> lessons = lessonDao.findByParticipantNo(loginUser.getNo());
    model.addAttribute("lessons", lessons);
  }

  /*
   * @RequestMapping("list") public ModelAndView list(HttpServletRequest request,
   * HttpServletResponse response) throws Exception { ModelAndView mv = new ModelAndView();
   * 
   * List<Board> list = boardDao.findAll(); mv.addObject("list", list);
   * mv.setViewName("board/list");
   * 
   * return mv; }
   */
  @RequestMapping("list")
  public void list(Model model) throws Exception {
    List<Board> list = boardDao.findAll();
    model.addAttribute("list", list);
  }

  @RequestMapping("update")
  public String update(Board board) throws Exception {
    boardDao.update(board);
    return "redirect:list";
  }
}

