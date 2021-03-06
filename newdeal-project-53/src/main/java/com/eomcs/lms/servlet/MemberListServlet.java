package com.eomcs.lms.servlet;

import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.Command;

@Component("/member/list")
public class MemberListServlet implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberListServlet(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  public void execute() {

    try {
      List<Member> list = memberDao.findAll();

      for (Member member : list) {
        System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", member.getNo(), member.getName(),
            member.getEmail(), member.getTel(), member.getRegisteredDate());
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
