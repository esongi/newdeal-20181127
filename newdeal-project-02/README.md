# newdeal-20181127 (설계: 엄진영, 추가수정: 박태규)

## 02 : 리터럴(literal), 변수(variables), 키보드 입력 사용

### 추가설명
~~~
Scanner keyIn = new Scanner(System.in);
// 키보드로 받을 때! (웹에서는 스캐너 안쓰임, 자바스크립트 input으로 받음)

int no = Interger.parseInt(keyIn.nextLine());
String title = keyIn.nextLine();
Date startDate = Date.valueof(keyIn.nextLine());

System.out.printf(“수업명 %s\n: “, title); 
// 출력문장 안에 값이 들어갈 떄는 printf 로 넣는다. 문자열 %s, 숫자 %d
~~~
