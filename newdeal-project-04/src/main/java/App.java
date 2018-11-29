import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    // eomcs-java-project-1.5
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    // new 로 만들었기에 heap에 생긴다
    // 주소를 저장하는 래퍼런스 변수
    // 객체 = 일반적, 인스턴스 = 콕 찝어서
    // 아직까지 객체 생성한게 아니다! 자리만 있지, 비어있다(널)
    Lesson[] lessons = new Lesson[LENGTH];

    // i는 배열의 인덱스용
    int i = 0;
    while (i < LENGTH) {

      // 이게 꼭 필요하다!!!! 인스턴스 생성해서 주소를 저장해야 한다
      // lesson = new Lesson();
      // lesson[i].xxx 대신
      Lesson lesson = new Lesson();

      System.out.print("번호? ");
      lesson.no = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명? ");
      lesson.title = keyboard.nextLine();

      System.out.print("설명? ");
      lesson.contents = keyboard.nextLine();

      System.out.print("시작일? ");
      lesson.startDate = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      lesson.endDate = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      lesson.totalHours = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      lesson.dayHours = Integer.parseInt(keyboard.nextLine());

      lessons[i] = lesson;
      i++; // 배열의 인덱스를 증가시킨다.

      // 사용자가 입력한 값을 소문자로 변환한다.
      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();

      // 입력 값이 "Y", "y", "" 이 아니면, 입력을 종료한다.
      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }

    keyboard.close();

    System.out.println(); // 빈 줄 출력

    // 배열에 입력한 개수만큼 출력한다.
    // 3칸 안에, 15칸 안에(마이너스 정렬), 10칸 안에(양:오른쪽)
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", lessons[j].no, lessons[j].title,
          lessons[j].startDate, lessons[j].endDate, lessons[j].totalHours);
    }
  }
}
