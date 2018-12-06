package com.eomcs.lms.servlet;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.Command;

@Component("/member/add")
public class MemberAddServlet implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberAddServlet(Scanner keyboard, MemberDao memberDao) {
    this.memberDao = memberDao;
    this.keyboard = keyboard;
  }

  public void execute() {

    try {

      Member member = new Member();

      System.out.print("회원번호? ");
      member.setNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("이름? ");
      member.setName(keyboard.nextLine());

      System.out.print("이메일? ");
      member.setEmail(keyboard.nextLine());

      System.out.print("암호? ");
      member.setPassword(keyboard.nextLine());

      memberDao.insert(member);

      System.out.println("입력했습니다");
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
