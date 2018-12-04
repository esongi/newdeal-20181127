package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberListCommand implements Command {

  Scanner keyboard;

  public MemberListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      rs = stmt.executeQuery("select mno, name, email, tel, cdt from member");

      while (rs.next()) {
        System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", rs.getInt("mno"), rs.getString("name"),
            rs.getString("email"), rs.getString("tel"), rs.getDate("cdt"));
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
