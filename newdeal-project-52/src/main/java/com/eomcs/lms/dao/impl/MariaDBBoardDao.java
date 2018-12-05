package com.eomcs.lms.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

// Spring IoC 컨테이너에게 이 클래스의 인스턴스를 자동 생성하도록 클래스에 표시해 둔다
@Component
public class MariaDBBoardDao implements BoardDao {
  // 유연하게 리턴 형태를 인터페이스

  SqlSessionFactory sqlSessionFactory;

  public MariaDBBoardDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Board> findAll() throws Exception {
    // openSession() 팩토리 메서드, 객체를 만들어서 돌려줌
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectList("BoardDao.findAll");
    }
  }

  public Board findByNo(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      return sqlSession.selectOne("BoardDao.findByNo", no);
    }
  }

  public int insert(Board board) throws Exception {

    // 트랜잭션 관리를 위해서 오토 커밋하면 안됨
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      int count = sqlSession.insert("BoardDao.insert", board);
      sqlSession.commit();
      return count;
    }
  }

  // 여기는 바로 업데이트 하는 내용, 커맨드랑 분리
  // 기존 방식으로 해봄
  public int update(Board board) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      int count = sqlSession.update("BoardDao.update", board);
      sqlSession.commit();
      return count;
    }
  }

  public int delete(int no) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
      int count = sqlSession.delete("BoardDao.delete", no);
      sqlSession.commit();
      return count;
    }
  }
}
