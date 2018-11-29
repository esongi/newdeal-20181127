package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    // 번호? 1
    // 내용? 게시글입니다.
    // 계속 입력하시겠습니까?(Y/n) y
    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] registeredDate = new Date[DEFAULT_SIZE];
    int[] count_num = new int[DEFAULT_SIZE];
    int len = 0;
    Scanner keyIn = new Scanner(System.in);

    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호?");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("내용?");
      contents[i] = keyIn.nextLine();

      count_num[i] = 0;

      registeredDate[i] = new Date(System.currentTimeMillis());

      System.out.print("계속 입력하시겠습니까?(Y/n) ");

      String input = keyIn.nextLine();

      len++;

      if (input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();

    // 1, 게시글입니다. , 2019-01-01, 0

    for (int i = 0; i < len; i++) {
      System.out.printf("%d, %s, %s, %d\n", no[i], contents[i], registeredDate[i], count_num[i]);
    }

  }
}
