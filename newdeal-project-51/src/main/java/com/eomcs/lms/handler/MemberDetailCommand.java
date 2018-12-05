package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/member/detail")
public class MemberDetailCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberDetailCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  public void execute() {

    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      Member member = memberDao.findByNo(no);

      if (member != null) {
        System.out.printf("이름: %s\n", member.getName());
        System.out.printf("이메일: %s\n", member.getEmail());
        System.out.printf("암호: %s\n", member.getPassword());
        System.out.printf("사진: %s\n", member.getPhoto());
        System.out.printf("전화: %s\n", member.getTel());
        System.out.printf("가입일: %s\n", member.getRegisteredDate());
      } else {
        System.out.println("해당 회원을 찾을 수 없습니다.");
      }
    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
