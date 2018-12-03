package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonListCommand implements Command {

  Scanner keyboard;

  public LessonListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
      DriverManager.registerDriver(new Driver());
      // DBMS에 연결하기
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      // SQL 전송을 담당할 객체를 준비
      stmt = con.createStatement();

      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      rs = stmt.executeQuery("select lno, title, sdt, edt, tot_hr from lesson");


      // DBMS에서 한 개의 레코드를 가져온다
      while (rs.next()) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", rs.getInt("lno"), rs.getString("title"),
            rs.getDate("sdt"), rs.getDate("edt"), rs.getInt("tot_hr"));
      }
    } catch (Exception e) {
      e.printStackTrace();

    } finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
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
