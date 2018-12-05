package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;

@Component("/member/delete")
public class MemberDeleteCommand implements Command {

  Scanner keyboard;
  MemberDao memberDao;

  public MemberDeleteCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  public void execute() {

    try {

      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      if (memberDao.delete(no) > 0) {
        System.out.println("해당 회원을 삭제했습니다");
      } else {
        System.out.println("해당 회원이 없습니다");
      }

    } catch (Exception e) {
      e.printStackTrace();

    }
  }
}
