package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao {
  // 유연하게 리턴 형태를 인터페이스
  public List<Board> findAll() throws Exception {
    DriverManager.registerDriver(new Driver());

    // auto closeable 구현된 변수만 올수있다( String 안됨)
    // 자동으로 close가 구현됨
    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement("select bno, cont, cdt, view from board");
        ResultSet rs = stmt.executeQuery();) {

      List<Board> list = new ArrayList<>();
      while (rs.next()) {
        // 데이터를 담을 인스턴스
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));

        list.add(board);
      }
      return list;

    } catch (Exception e) {
      // 처리하는게 아니라 보고 해야 함
      throw e;
    }
  }

  public Board findByNo(int no) throws Exception {

    DriverManager.registerDriver(new Driver());
    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con
            .prepareStatement("select bno, cont, cdt, view, mno, lno from board where bno =?");) {

      // DBMS에서 한 개의 레코드를 가져온다
      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("bno"));
          board.setContents(rs.getString("cont"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setViewCount(rs.getInt("view"));

          board.setWriterNo(rs.getInt("mno"));
          board.setLessonNo(rs.getInt("lno"));
          return board;

        } else {
          return null;
          // System.out.println("해당 게시글을 찾을 수 없습니다.");
        }
      }

    }
  }

  public int insert(Board board) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into board(cont, mno, lno) values(?,?,?)");) {

      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getWriterNo());
      stmt.setInt(3, board.getLessonNo());

      return stmt.executeUpdate();
    }

  }

  // 여기는 바로 업데이트 하는 내용, 커맨드랑 분리
  // 기존 방식으로 해봄
  public int update(Board board) throws Exception {

    Connection con = null;
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.prepareStatement("update board set cont=? where bno=?");

      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getNo());
      return stmt.executeUpdate();

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
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      stmt = con.prepareStatement("delete from board where bno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();

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
