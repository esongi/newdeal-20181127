package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberAddCommand implements Command {

  Scanner keyboard;

  public MemberAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {


    Connection con = null;
    Statement stmt = null;

    try {

      System.out.print("회원번호? ");
      String memberNo = keyboard.nextLine();

      System.out.print("이름? ");
      String name = keyboard.nextLine();

      System.out.print("이메일? ");
      String email = keyboard.nextLine();

      System.out.print("암호? ");
      String pwd = keyboard.nextLine();

      // System.out.print("사진? ");
      // String photo = keyboard.nextLine();

      // System.out.print("전화? ");
      // String tel = keyboard.nextLine();

      // Date regDate = new Date(System.currentTimeMillis());


      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      stmt.executeUpdate("INSERT INTO MEMBER(MNO,NAME,EMAIL,PWD)" + " values(" + memberNo + ",'"
          + name + "','" + email + "','" + pwd + "')");
      // DBMS에서 한 개의 레코드를 가져온다

      // INSERT INTO MEMBER(MNO,NAME,EMAIL,PWD) VALUES(1,'홍길동','user01@test.com','1111');
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
