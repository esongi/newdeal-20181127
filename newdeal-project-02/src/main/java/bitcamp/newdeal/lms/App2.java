package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    // 번호: 1
    // 이름: 홍길동
    // 이메일: hong@test.com
    // 암호: 1111
    // 사진: hong.png
    // 전화: 1111-2222
    // 가입일: 2019-01-01

    Scanner keyIn = new Scanner(System.in);

    System.out.print("번호?");
    int no = Integer.parseInt(keyIn.nextLine());

    System.out.print("이름?");
    String name = keyIn.nextLine();

    System.out.print("이메일?");
    String email = keyIn.nextLine();

    System.out.print("암호?");
    String password = keyIn.nextLine();

    System.out.print("사진?");
    String photo = keyIn.nextLine();

    System.out.print("전화?");
    String phone_num = keyIn.nextLine();

    System.out.print("가입일?");
    // System.currentTimeMillis() 에 대한 이해!, 변수 네이밍
    Date registeredDate = new Date(System.currentTimeMillis());

    keyIn.close();

    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", phone_num);
    System.out.printf("가입일: %s\n", registeredDate);
  }
}
