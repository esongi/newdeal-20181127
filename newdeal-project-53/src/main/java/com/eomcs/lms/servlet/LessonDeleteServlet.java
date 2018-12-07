package com.eomcs.lms.servlet;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.handler.Command;

@Component("/lesson/delete")
public class LessonDeleteServlet implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDeleteServlet(Scanner keyboard, LessonDao lessonDao) {
    this.lessonDao = lessonDao;
    this.keyboard = keyboard;
  }

  public void execute() {

    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      lessonDao.delete(no);

      System.out.println("수업을 삭제했습니다");

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
