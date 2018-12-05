## 작업

## 웹 프로젝트 관련 빌드 명령을 사용할 수 있게 준비하기

- build.gradle
    -`eclipse` 플러그인 대신 `eclipse-wtp` 플러그인을 추가한다.
    - `웹 어플리케이션 배치 파일(.war)을 만들 `war` 플러그인을 추가한다
    -단독으로 실행할 수 없기 때문에 application은 제거한다
    -application 플러그인과 관련된 변수 mainClassName을 제거한다
## 서블릿 애플리케이션 개발에 사용할 라이브러리 추가하기

servlet-api를 검색하여 라이브러리 정보를 알아낸다


## 이클립스 웹 프로젝트 설정 파일 준비하기

- src/main/webapp
    - HTML, CSS, JavaScript, PNG, JPEG, JSP 등 웹 자원을 디렉토리를 생성한다
- index.html
    - 웹 애플리케이션에 대해 간단히 소개하는 웹 페이지를 만든다
    