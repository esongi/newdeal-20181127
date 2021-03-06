# eomcs-java-project-1.5

배열과 흐름 제어문 활용하기

- 배열을 활용하여 여러 개의 데이터를 저장하는 방법
- 반복문과 조건문을 사용하여 실행 흐름을 제어하는 방법

## 프로젝트 - 수업관리 시스템  

### 과제 1: 여러 개의 수업 내용을 입력 받아 출력하라.

- App.java
    - main()에 코드를 작성한다.

#### 실행 결과

목록으로 출력할 항목은 `번호,수업명,시작일~종료일,총수업시간`이다.

```
번호? 1
수업명? 자바 프로젝트 실습
수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
시작일? 2019-01-02
종료일? 2019-05-28
총수업시간? 1000
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y

번호? 2
수업명? 자바 프로그래밍 기초
수업내용? 자바 언어 기초 문법을 학습하기
시작일? 2019-02-01
종료일? 2019-02-28
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) y

번호? 3
수업명? 자바 프로그래밍 고급
수업내용? 디자인 패턴과 리랙토링 기법 학습하기
시작일? 2019-03-02
종료일? 2019-03-30
총수업시간? 160
일수업시간? 8

계속 입력하시겠습니까?(Y/n) n

1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160
```

### 과제 2: 여러 명의 회원 정보를 입력 받아 출력하라.

- App2.java
    - main()에 코드를 작성한다.

#### 실행 결과

목록으로 출력할 항목은 `번호,이름,이메일,전화,가입일`이다.

```
번호? 1
이름? 홍길동
이메일? hong@test.com
암호? 1111
사진? hong.png
전화? 1111-2222

계속 입력하시겠습니까?(Y/n) y

번호? 2
이름? 임꺽정
이메일? lim@test.com
암호? 1111
사진? lim.png
전화? 1111-2223

계속 입력하시겠습니까?(Y/n) y

번호? 3
이름? 전봉준
이메일? jeon@test.com
암호? 1111
사진? jeon.png
전화? 1111-2224

계속 입력하시겠습니까?(Y/n) n

1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01
```

### 과제 3: 여러 개의 게시글을 입력 받아 출력하라.

- App3.java
    - main()에 코드를 작성한다.

#### 실행 결과

목록으로 출력할 항목은 `번호,내용,작성일,조회수`이다.

```
번호? 1
내용? 게시글입니다.

계속 입력하시겠습니까?(Y/n) y

번호? 2
내용? 두 번째 게시글입니다.

계속 입력하시겠습니까?(Y/n) y

번호? 3
내용? 두 번째 게시글입니다.

1, 게시글입니다.              , 2019-01-01, 0
2, 두 번째 게시글입니다.        , 2019-01-01, 0
3, 세 번째 게시글입니다.        , 2019-01-01, 0
```

## 실습 소스

- src/main/java/App.java 변경
- src/main/java/App2.java 변경
- src/main/java/App3.java 변경

## 추가 설명

**.gitignore**
- Git으로 관리하지 않을 파일을 지정한다.
- 예를 들면 로그 파일(.log)이나 빌드 도구가 자동으로 생성한 파일 또는 디렉토리 등.
- 패턴을 사용하여 Git이 무시할 파일을 지정한다.
  - 빈 줄이나 `#`으로 시작하는 줄은 주석으로 간주한다.
  - 표준 Glob 패턴을 사용한다.
  - `/`로 시작하면 하위 디렉토리에 적용되지 않는다.
  - 디렉토리는 끝에 `/`을 붙인다.
  - `!`로 시작하는 파일은 무시하지 않는다.

```
예1) 주석을 표시하는 방법
#이것은 주석입니다. 또는 빈 줄.

예2) bin/ 디렉토리를 통째로 무시하기
bin/

예3) 현재 디렉토리의 *.log 파일만 무시하기. src/*.log처럼 기타 하위 디렉토리에 있는 *.log 파일은 포함하기
/*.log

예4) src/*.class 파일은 무시하고, src/main/*.class 파일은 포함하기
src/*.class

예5) src 디렉토리 및 그 하위 디렉토리에 있는 *.class 파일 무시하기
src/**/*.class

예6) 현재 디렉토리 및 그 하위 디렉토리에 있는 모든 *.log 파일 무시하기
*.log

예7) 확장자가 '.o' 또는 '.a'인 파일 무시하기
*.[oa]

예8) *~
파일명이 ~로 끝나는 파일

예9) 만약 *.log 파일을 무시한다면, cotext.log 파일은 무시하지 않고 포함하기
!context.log
```

**App**
~~~
// new 로 만들었기에 heap에 생긴다
// 주소를 저장하는 래퍼런스 변수
// 객체 = 일반적, 인스턴스 = 콕 찝어서
// 아직까지 객체 생성한게 아니다! 자리만 있지, 비어있다(널)
Lesson[] lessons = new Lesson[LENGTH];

// 인스턴스 생성해서 주소를 저장해야 한다
Lesson lesson = new Lesson();

// 사용자가 입력한 값을 소문자로 변환한다.(대문자:toUpperCase)
String answer = keyIn.nextLine().toLowerCase();

// 3칸 안에, 15칸 안에(마이너스 정렬), 10칸 안에(양:오른쪽)
System.out.printf("%3d, %-15s, %10s", lessons[j].no, lessons[j].title, lessons[j].startDate);

// 인스턴스 필드(데이터를 개별적으로 다루어야 한다)
// static 필드(클래스 필드: 하나의 데이터로 공유한다)
~~~

