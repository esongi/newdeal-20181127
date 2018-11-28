package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // final - 한번 저장하면 값을 바꾸면 에러난다
    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] title = new String[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] startDate = new Date[DEFAULT_SIZE];
    Date[] endDate = new Date[DEFAULT_SIZE];
    int[] totalHours = new int[DEFAULT_SIZE];
    int[] dayHours = new int[DEFAULT_SIZE];

    // 사이즈를 위한 변수
    int len = 0;

    // system.in은 1바이트나 조금씩밖에 못읽는다
    // 스캐너는 모른다, 생성자 필요, 키보드 주소가 필요.
    // 스캐너는 system.in(의존 객체)을 읽는다.
    Scanner keyIn = new Scanner(System.in);

    // i 대신 len으로 해도 되지만 반복문을 위한 i
    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호?");
      // 클래스 메서드. 특정 작업에서 작업하는 것이 아님(static), 보편적으로 사용하는것
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.println("수업명?");
      // 인스턴스 메서드. 특정 인스턴스에서만 작업해야 한다
      title[i] = keyIn.nextLine();

      System.out.println("내용?");
      contents[i] = keyIn.nextLine();

      System.out.println("강의시작일?");
      startDate[i] = Date.valueOf(keyIn.nextLine());

      System.out.println("강의종료일?");
      endDate[i] = Date.valueOf(keyIn.nextLine());

      System.out.print("총강의시간?");
      totalHours[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("일강의시간?");
      dayHours[i] = Integer.parseInt(keyIn.nextLine());

      len++;

      System.out.println("계속하시겠습니까?(Y/n) ");
      String input = keyIn.nextLine();

      if (input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();

    for (int i = 0; i < len; i++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", no[i], title[i], startDate[i], endDate[i],
          totalHours[i]);
    }
  }
}
