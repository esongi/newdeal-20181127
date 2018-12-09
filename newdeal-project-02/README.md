# newdeal-20181127 (설계: 엄진영, 추가수정: 박태규)

## 02 : 리터럴(literal), 변수(variables), 키보드 입력 사용

### 추가설명
~~~
Scanner keyIn = new Scanner(System.in);
// 키보드로 받을 때! (웹에서는 스캐너 안쓰임, 자바스크립트 input으로 받음)

String title = keyIn.nextLine();
// 키보드로 받은 값을 string 타입으로 저장
int no = Interger.parseInt(keyIn.nextLine());
// 키보드로 받은 값을 int 타입으로 변환해서 저장
Date startDate = Date.valueof(keyIn.nextLine());
// 키보드로 받은 값을 Date 타입으로 변환해서 저장
System.out.printf(“수업명 %s\n: “, title); 
// 출력문장 안에 값이 들어갈 떄는 printf 로 넣는다. 문자열 %s, 숫자 %d
~~~
