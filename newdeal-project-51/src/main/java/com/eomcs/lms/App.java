package com.eomcs.lms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.handler.Command;

public class App {
  // 4.6
  static Scanner keyboard;
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    // AppConfig 클래스가 메모리에 로딩되어 있지 않다면,
    // 지금 즉시 로딩한 후 그 로딩된 클래스 정보를 리턴하라!
    // Spring Ioc 컨테이너 준비하기
    // xxx.class 파일 확장명이 아님, 스태틱 변수, 클래스 정보를 가리키는 주소 저장
    // Class<?> clazz = Class.forName("com.eomcs.lms.AppConfig");
    AnnotationConfigApplicationContext iocContainer =
        new AnnotationConfigApplicationContext(AppConfig.class);

    /*
     * 
     * System.out.println(iocContainer.getBeanDefinitionCount()); String[] names =
     * iocContainer.getBeanDefinitionNames(); for(String name : names) {
     * System.out.printf("%s >> %s\n",name, iocContainer.getBean(name).getClass().getName()); }
     */

    keyboard = (Scanner) iocContainer.getBean("keyboard");

    while (true) {
      String command = prompt();

      commandHistory.push(command);
      commandHistory2.offer(command);

      try {
        Command commandHandler = (Command) iocContainer.getBean(command);
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 처리 중 오류 발생!");
        }

      } catch (Exception e) {
        if (command.equals("quit")) {
          System.out.println("안녕!");
          break;
        } else if (command.equals("history")) {
          printCommandHistory();
        } else if (command.equals("history2")) {
          printCommandHistory2();
        } else {
          System.out.println("실행할 수 없는 명령입니다.");
        }
      }
      System.out.println();
    }
    keyboard.close();
    iocContainer.close();

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
