package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  public void execute() {

    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      Member member = memberDao.findByNo(no);

      System.out.printf("이름(%s)? ", member.getName());
      member.setName(keyboard.nextLine());

      System.out.printf("이메일(%s)? ", member.getEmail());
      member.setEmail(keyboard.nextLine());

      System.out.printf("암호(%s)? ", member.getPassword());
      member.setPassword(keyboard.nextLine());

      System.out.printf("사진(%s)? ", member.getPhoto());
      member.setPhoto(keyboard.nextLine());

      System.out.printf("전화번호(%s)? ", member.getTel());
      member.setTel(keyboard.nextLine());

      memberDao.update(member);
      
      System.out.println(member);
      
      
      System.out.println("변경했습니다");
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
