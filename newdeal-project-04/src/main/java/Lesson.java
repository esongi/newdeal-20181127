import java.sql.Date;

// 새 데이터 타입
// 새로운 종류의 메모리를 구성하는 설계도
public class Lesson {

  // 인스턴스 필드(데이터를 개별적으로 다루어야 한다)
  // static 필드(클래스 필드: 하나의 데이터로 공유하고 싶다)
  int no;
  String title;
  String contents;
  Date startDate;
  Date endDate;
  int totalHours;
  int dayHours;
}
