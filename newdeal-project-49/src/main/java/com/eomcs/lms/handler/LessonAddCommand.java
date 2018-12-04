package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonAddCommand implements Command {

  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {

    Connection con = null;
    Statement stmt = null;

    try {

      System.out.print("강의번호? ");
      String lessonNo = keyboard.nextLine();

      System.out.print("제목? ");
      String title = keyboard.nextLine();

      System.out.print("내용? ");
      String content = keyboard.nextLine();

      System.out.print("시작날짜? ");
      Date startDate = Date.valueOf(keyboard.nextLine());

      System.out.print("종료날짜? ");
      Date endDate = Date.valueOf(keyboard.nextLine());

      System.out.print("회원번호? ");
      String memberNo = keyboard.nextLine();

      System.out.println("총수업시간?");
      String totalHour = keyboard.nextLine();

      System.out.print("하루수업시간? ");
      String dayHour = keyboard.nextLine();

      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      stmt.executeUpdate("insert into lesson(LNO,TITLE,CONT,SDT,EDT,MNO,TOT_HR,DAY_HR)" + " values("
          + lessonNo + ",'" + title + "','" + content + "','" + startDate + "','" + endDate + "',"
          + memberNo + "," + totalHour + "," + dayHour + ")");
      // DBMS에서 한 개의 레코드를 가져온다

      System.out.println("입력했습니다");
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        stmt.close();
      } catch (Exception e) {
      }
      try {
        con.close();
      } catch (Exception e) {
      }
    }

  }

}
