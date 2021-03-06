package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> list;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }

  public void listBoard() {
    Board[] boards = list.toArray(new Board[] {});
    for (Board board : boards) {
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

  public void detailBoard() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당하는 게시물을 찾을 수  없습니다");
      return;
    }

    // 해당하는 번호가 있으니 값을 설정
    Board board = list.get(index);
    System.out.printf("내용:%s\n", board.getContents());
    System.out.printf("작성일:%s\n", board.getCreatedDate());
  }

  public void updateBoard() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당하는 게시물을 찾을 수 없습니다");
      return;
    }
    Board board = list.get(index);

    try {
      // 기존 값 복제
      Board temp = board.clone();

      System.out.println("내용? ");
      String input = keyboard.nextLine();

      // 값이 제대로 들어왔다면, 아무런 입력이 없으면 변화 없이 설정
      if (input.length() > 0) {
        temp.setContents(input);
      }
      list.set(index, temp);
      System.out.println("게시글을 변경했습니다");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }

  public void deleteBoard() {
    System.out.println("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("해당하는 게시글을 찾을 수 없습니다");
      return;
    }
    list.remove(index);
    System.out.println("해당하는 게시글을 삭제했습니다");
  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
