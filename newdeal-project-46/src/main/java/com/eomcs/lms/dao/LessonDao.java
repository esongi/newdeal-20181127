package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class LessonDao {
  
  // list
  public List<Lesson> findAll() throws Exception {
    DriverManager.registerDriver(new Driver());

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select lno, title, sdt, edt, tot_hr from lesson");) {

      List<Lesson> list = new ArrayList<>();
      while (rs.next()) {
        // 데이터를 담을 인스턴스
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lno"));
        lesson.setTitle((rs.getString("title")));
        lesson.setStartDate((rs.getDate("sdt")));
        lesson.setEndDate((rs.getDate("edt")));
        lesson.setTotalHours((rs.getInt("tot_hr")));

        list.add(lesson);
      }
      return list;

    } catch (Exception e) {
      // 처리하는게 아니라 보고 해야 함
      throw e;
    }
  }

  // detail
  public Lesson findByNo(int no) throws Exception {

    DriverManager.registerDriver(new Driver());
    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select title, cont, sdt, edt, tot_hr, day_hr" + " from lesson" + " where lno =" + no);) {

      if (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setTitle((rs.getString("title")));
        lesson.setContents(rs.getString("cont"));
        lesson.setStartDate((rs.getDate("sdt")));
        lesson.setEndDate((rs.getDate("edt")));
        lesson.setTotalHours((rs.getInt("tot_hr")));
        lesson.setDayHours(rs.getInt("day_hr"));

        return lesson;

      } else {
        return null;
      }
    }
  }

  public int insert(Board board) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("insert into board(cont, mno, lno)" + " values('"
          + board.getContents() + "'," + board.getWriterNo() + "," + board.getLessonNo() + ")");
    }

  }

  // 여기는 바로 업데이트 하는 내용, 커맨드랑 분리
  // 기존 방식으로 해봄
  public int update(Board board) throws Exception {

    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      return stmt.executeUpdate(
          "update board set cont='" + board.getContents() + "' where bno=" + board.getNo());

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

  public int delete(int no) throws Exception {

    Connection con = null;
    Statement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.createStatement();

      return stmt.executeUpdate("delete from board where bno=" + no);

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
