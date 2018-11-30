package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> list;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    // 생략 가능 : <> 앞에서 이미 명시했기에
    this.list = new ArrayList<>(20);
  }

  public void listBoard() {
    
    //예제랑 비교해보길. 생성 방법 다름
    // 배열 생성하자마자 초기화, 빈 배열
    Board[] boards = new Board[list.size()];

    // 같은 주소이기에 안해도 됨
    // Object[] boards = list.toArray(boards);
    list.toArray(boards);

    // for문에 object이기에, 안에서 다시 또 형변환을 해줘야 함
    // for (Object obj : boards) {
    // 이미 board이기에 형변환 안해도 됨
    for (Board board : boards) {
      // Board board = (Board) obj;
      System.out.printf("%3d, %-20s, %s, %d\n", board.getNo(), board.getContents(),
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis()));

    board.setViewCount(0);

    list.add(board);

    System.out.println("저장하였습니다.");
  }

}
