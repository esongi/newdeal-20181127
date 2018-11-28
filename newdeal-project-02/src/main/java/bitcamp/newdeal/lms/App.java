package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    // system.in은 1바이트나 조금씩밖에 못읽는다
    // 스캐너는 모른다, 생성자 필요, 키보드 주소가 필요.
    // 스캐너는 system.in(의존 객체)을 읽는다.
    Scanner keyIn = new Scanner(System.in);

    System.out.print("번호?");
    // 클래스 메서드. 특정 작업에서 작업하는 것이 아님(static), 보편적으로 사용하는것
    int no = Integer.parseInt(keyIn.nextLine());

    System.out.println("수업명?");
    // 인스턴스 메서드. 특정 인스턴스에서만 작업해야 한다
    String title = keyIn.nextLine();

    System.out.println("내용?");
    String contents = keyIn.nextLine();

    System.out.println("강의시작일?");
    Date startDate = Date.valueOf(keyIn.nextLine());

    System.out.println("강의종료일?");
    Date endDate = Date.valueOf(keyIn.nextLine());

    System.out.print("총강의시간?");
    int totalHours = Integer.parseInt(keyIn.nextLine());

    System.out.print("일강의시간?");
    int dayHours = Integer.parseInt(keyIn.nextLine());

    keyIn.close();

    System.out.println("번호: " + no);
    System.out.printf("수업명: %s\n", title); // 문자열 안에 삽입되는 명령어, 이스케이프 문자
    System.out.printf("내용: %s\n", contents);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("총수업시간: %d\n", totalHours);
    System.out.printf("일수업시간: %d\n", dayHours);
  }
}
