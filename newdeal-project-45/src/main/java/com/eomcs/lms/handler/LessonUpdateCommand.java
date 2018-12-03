package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {

    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      System.out.print("번호? ");
      String no = keyboard.nextLine();

      ResultSet rs = stmt.executeQuery("select * from lesson where lno=" + no);
      rs.next();
      String oldTitle = rs.getString("title");
      String oldContent = rs.getString("cont");
      Date oldStartDate = rs.getDate("sdt");
      Date oldEndDate = rs.getDate("edt");
      int oldTotalHour = rs.getInt("tot_hr");
      int oldDayHour = rs.getInt("day_hr");
      rs.close();

      System.out.printf("수업명(%s)? ", oldTitle);
      String title = keyboard.nextLine();

      System.out.printf("설명(%s)? ", oldContent);
      String content = keyboard.nextLine();

      System.out.printf("시작일(%s)? ", oldStartDate);
      Date startDate = Date.valueOf(keyboard.nextLine());

      System.out.printf("종료일(%s)? ", oldEndDate);
      Date endDate = Date.valueOf(keyboard.nextLine());

      System.out.printf("총수업시간(%s)? ", oldTotalHour);
      String totalHour = keyboard.nextLine();

      System.out.printf("일수업시간(%s)? ", oldDayHour);
      String dayHour = keyboard.nextLine();

      // sql을 서버에 전송
      stmt.executeUpdate("update lesson set title='" + title + "', cont='" + content + "', sdt='"
          + startDate + "', edt='" + endDate + "', tot_hr='" + totalHour + "', day_hr='" + dayHour
          + "' where lno=" + no);
      System.out.println("변경했습니다");
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
