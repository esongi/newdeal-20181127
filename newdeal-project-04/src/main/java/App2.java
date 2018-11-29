import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;

    int i = 0;

    Lesson[] lessons = new Lesson[LENGTH];
    // 번호? 1
    // 이름? 홍길동
    // 이메일? hong@test.com
    // 암호? 1111
    // 사진? hong.png
    // 전화? 1111-2222

    // 계속 입력하시겠습니까?(Y/n) y

    while (i < LENGTH) {
      Lesson lesson = new Lesson();

      System.out.print("번호? ");
      lesson.no = Integer.parseInt(keyboard.nextLine());

      System.out.print("이름? ");
      lesson.name = keyboard.nextLine();

      System.out.print("이메일? ");
      lesson.email = keyboard.nextLine();

      System.out.print("암호? ");
      lesson.password = keyboard.nextLine();

      System.out.print("사진? ");
      lesson.photo = keyboard.nextLine();

      System.out.print("전화? ");
      lesson.tel = keyboard.nextLine();

      lesson.registeredDate = new Date(System.currentTimeMillis());

      lessons[i] = lesson;
      i++;

      System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
      String answer = keyboard.nextLine().toLowerCase();

      if (!answer.equals("y") && answer.length() > 0) {
        break;
      }

      System.out.println();
    }

    keyboard.close();

    System.out.println();

    // 1, 홍길동 , hong@test.com , 1111-2222 , 2019-01-01
    // 배열에 입력한 개수만큼 출력한다.
    for (int j = 0; j < i; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", lessons[j].no, lessons[j].name,
          lessons[j].email, lessons[j].tel, lessons[j].registeredDate);
    }
  }
}
