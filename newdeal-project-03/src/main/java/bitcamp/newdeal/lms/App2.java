package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    // 번호? 1
    // 이름? 홍길동
    // 이메일? hong@test.com
    // 암호? 1111
    // 사진? hong.png
    // 전화? 1111-2222
    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] password = new String[DEFAULT_SIZE];
    String[] photo = new String[DEFAULT_SIZE];
    String[] phone_num = new String[DEFAULT_SIZE];
    Date[] registeredDate = new Date[DEFAULT_SIZE];
    int len = 0;
    Scanner keyIn = new Scanner(System.in);

    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호?");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("이름?");
      name[i] = keyIn.nextLine();

      System.out.print("이메일?");
      email[i] = keyIn.nextLine();

      System.out.print("암호?");
      password[i] = keyIn.nextLine();

      System.out.print("사진?");
      photo[i] = keyIn.nextLine();

      System.out.print("전화?");
      phone_num[i] = keyIn.nextLine();

      registeredDate[i] = new Date(System.currentTimeMillis());

      len++;

      System.out.println("계속 입력하시겠습니까?(Y/n) ");
      String input = keyIn.nextLine();

      if (input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }

    keyIn.close();

    // 1, 홍길동 , hong@test.com , 1111-2222 , 2019-01-01

    for (int i = 0; i < len; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], name[i], email[i], phone_num[i],
          registeredDate[i]);
    }
  }
}
