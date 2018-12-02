package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[] {});
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", lesson.getNo(), lesson.getTitle(),
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }

  // 바로 주입이 아니라, 실행하고 나서 주입받는다
  public void detailLesson() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int index = indexOfLesson(no);

    // 없을 경우
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다");
      return;
    }

    // 특정 목록 값 얻어오기
    Lesson lesson = list.get(index);

    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("설명: %s\n", lesson.getContents());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());

  }

  public void updateLesson() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int index = indexOfLesson(no);

    // 없을 경우
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다");
      return;
    }

    // 특정 목록 값 얻어오기
    Lesson lesson = list.get(index);

    try {
      // 일단 기존 값을 복제한다
      Lesson temp = lesson.clone();
      System.out.printf("수업명(%s)? ", lesson.getTitle());
      String input = keyboard.nextLine();

      if (input.length() > 0) {
        temp.setTitle(input);
      }

      System.out.printf("설명(%s)? ", lesson.getContents());
      if ((input = keyboard.nextLine()).length() > 0) {
        temp.setContents(input);
      }

      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      if ((input = keyboard.nextLine()).length() > 0) {
        temp.setStartDate(Date.valueOf(input));
      }

      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      if ((input = keyboard.nextLine()).length() > 0) {
        temp.setEndDate(Date.valueOf(input));
      }

      System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      if ((input = keyboard.nextLine()).length() > 0) {
        temp.setTotalHours(Integer.parseInt(input));
      }

      System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
      if ((input = keyboard.nextLine()).length() > 0) {
        temp.setDayHours(Integer.parseInt(input));
      }

      // 값을 변경
      list.set(index, temp);
      System.out.println("수업을 변경했습니다");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }

  public void deleteLesson() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    //
    int index = indexOfLesson(no);
    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다");
      return;
    }
    // 삭제
    list.remove(index);
    System.out.println("수업을 삭제했습니다");
  }

  // 번호를 주입하면 해당 배열 첫번째부터 돌며 값(수)을 찾는다
  private int indexOfLesson(int no) {
    // 저장된 목록에서 수업 번호로 항목을 찾는 코드
    for (int i = 0; i < list.size(); i++) {
      Lesson l = list.get(i);
      if (l.getNo() == no) {
        return i;
      }
    }
    // 실패?
    return -1;
  }
}
