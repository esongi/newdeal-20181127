package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Component("/lesson/update")
public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  LessonDao lessonDao;

  public LessonUpdateCommand(Scanner keyboard, LessonDao lessonDao) {
    this.lessonDao = lessonDao;
    this.keyboard = keyboard;
  }

  public void execute() {

    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      Lesson lesson = lessonDao.findByNo(no);

      System.out.printf("수업명(%s)? ", lesson.getTitle());
      lesson.setTitle(keyboard.nextLine());

      System.out.printf("설명(%s)? ", lesson.getContents());
      lesson.setContents(keyboard.nextLine());

      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.printf("총수업시간(%s)? ", lesson.getTotalHours());
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.printf("일수업시간(%s)? ", lesson.getDayHours());
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

      lessonDao.update(lesson);
      System.out.println("변경했습니다");
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
