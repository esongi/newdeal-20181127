package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Member;

public interface MemberDao {
  Member findByEmailPassword(String email, String password) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByNo(int no) throws Exception;

  int insert(Member member) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;
}
