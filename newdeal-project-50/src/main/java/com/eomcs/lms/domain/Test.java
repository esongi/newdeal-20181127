package com.eomcs.lms.domain;

import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    while (true) {
      System.out.println("숫자? ");
      int i = Integer.parseInt(keyboard.nextLine());

      System.out.println(i & 7);
    }
  }
}
