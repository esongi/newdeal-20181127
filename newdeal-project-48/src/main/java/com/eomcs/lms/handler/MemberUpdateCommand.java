package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberUpdateCommand implements Command {

  Scanner keyboard;

  public MemberUpdateCommand(Scanner keyboard) {
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

      ResultSet rs = stmt.executeQuery("select * from member where mno=" + no);
      rs.next();

      String oldName = rs.getString("name");
      String oldEmail = rs.getString("email");
      String oldPwd = rs.getString("pwd");
      String oldPhoto = rs.getString("photo");
      String oldTel = rs.getString("tel");
      rs.close();

      System.out.printf("이름(%s)? ", oldName);
      String name = keyboard.nextLine();

      System.out.printf("이메일(%s)? ", oldEmail);
      String email = keyboard.nextLine();

      System.out.printf("암호(%s)? ", oldPwd);
      String pwd = keyboard.nextLine();

      System.out.printf("사진(%s)? ", oldPhoto);
      String photo = keyboard.nextLine();

      System.out.printf("전화번호(%s)? ", oldTel);
      String tel = keyboard.nextLine();

      // sql을 서버에 전송
      stmt.executeUpdate("update member set name='" + name + "', email='" + email + "', pwd='" + pwd
          + "', photo='" + photo + "', tel='" + tel + "' where mno=" + no);
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
