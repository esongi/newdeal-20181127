package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  public Scanner keyboard;
  static final int LENGTH = 10;

  // 값을 구분하고 싶음
  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;

  // 생성자를 만들었기 때문에 값을 강제적으로 넣게 함
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  // 인스턴스 주소가 필요함(static 이 없으므로)
  public void listBoard() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", this.boards[j].no, this.boards[j].contents,
          this.boards[j].createdDate, this.boards[j].viewCount);
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    board.contents = keyboard.nextLine();

    board.createdDate = new Date(System.currentTimeMillis());

    board.viewCount = 0;

    this.boards[boardIdx] = board;
    this.boardIdx++;

    System.out.println("저장하였습니다.");
  }

}
