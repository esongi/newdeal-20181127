package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {

  static final int LENGTH = 10;
  // 변수 list : 이제는 배열과 인덱스가 외부에서 필요하지않고 여기서만 사용하므로, 인식하기 좋은 단어로 수정
  private Lesson[] list;
  private int size = 0;

  public LessonList() {
    // 생략가능함
    this.list = new Lesson[LENGTH];
  }

  // 최대 크기, 버퍼 크기
  public LessonList(int initialCapacity) {

    if (initialCapacity > LENGTH) {
      this.list = new Lesson[initialCapacity];
    } else {
      this.list = new Lesson[LENGTH];
    }
  }

  public Lesson[] toArray() {
    return Arrays.copyOf(list, size);
  }

  public void add(Lesson lesson) {

    if (size >= list.length) {
      int oldLength = list.length;
      // 강제형변환, 부동소수점 계산은 cpu를 많이 사용함. 정수와 정수는 간단.
      // int newCapacity = oldLength + (int) (oldLength * 0.5);
      // 곱하기 2 , 나누기 2 할때 비트연산자 이용하면 효과적
      int newCapacity = oldLength + (oldLength >> 1);
      // 늘어난 사이즈의 배열을 새로 저장
      Arrays.copyOf(list, newCapacity);
    }
    // 이렇게도 가능하지만 가독성을 좋기 위해서 풀어서 쓰기도 함
    list[size++] = lesson;
  }
}
