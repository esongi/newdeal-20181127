# newdeal-20181127 (설계: 엄진영, 추가수정: 박태규)

## 01 : Maven 기본 자바 프로젝트 폴더 준비

####Settings.gradle 
plugins {
    id 'java'
    id 'application'
    id 'eclipse'
}
이 상태를 유지해야 제대로 설정이 되는 듯

rootProject.name = 'newdeal-project-01'
**rootProject.name** 을 설정하면 다른데서 사용되는 프로젝트명이 일제히 바뀐다. 다른 곳에서 프로젝트명을 수정해도 다시 실행시 rootProject 기준으로 바뀜
cmd 에서 **gradle eclipse** 실행시 재설정됨



