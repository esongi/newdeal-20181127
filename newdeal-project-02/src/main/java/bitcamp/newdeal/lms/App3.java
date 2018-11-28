package bitcamp.newdeal.lms;


import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    // 번호: 1
    // 내용: 게시글입니다.
    // 작성일: 2019-01-01
    // 조회수: 0

    Scanner keyIn = new Scanner(System.in);

    System.out.println("번호?");
    int no = Integer.parseInt(keyIn.nextLine());

    System.out.println("내용?");
    String content = keyIn.nextLine();

    Date writedDate = new Date(System.currentTimeMillis());
    int count_num = 0;

    keyIn.close();

    System.out.printf("번호: %d\n", no);
    System.out.printf("번호: %s\n", content);
    System.out.printf("번호: %s\n", writedDate);
    System.out.printf("조회수: %d\n", count_num);
  }
}
