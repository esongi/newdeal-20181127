package com.eomcs.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {
  // v3.4, v3.5, v3.6
  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) {

    ArrayList<Board> boards = new ArrayList<>();
    ArrayList<Lesson> lessons = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/list", new BoardListCommand(keyboard, boards));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boards));
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boards));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boards));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boards));
    commandMap.put("/hello", new HelloCommand(keyboard));

    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessons));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessons));
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessons));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessons));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessons));

    commandMap.put("/member/list", new MemberListCommand(keyboard, members));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, members));
    commandMap.put("/member/add", new MemberAddCommand(keyboard, members));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, members));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, members));

    commandMap.put("/hello", new HelloCommand(keyboard));

    while (true) {
      String command = prompt();

      Command commandHandler = commandMap.get(command);

      // 예외처리 >> 예외가 발생했을 때 시스템을 멈추지 않게 함
      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 처리 중 오류 발생!");
        }
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      System.out.println();
    }

    keyboard.close();
  }

  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
