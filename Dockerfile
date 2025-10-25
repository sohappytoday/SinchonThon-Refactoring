#OpenJDK 21이 설치된 공식 이미지 사용
FROM openjdk:21-jdk

# 메타데이터 기록
LABEL maintainer="kgeo6264@gmail.com"

# 컨테이너 내부 작업 디렉터리 지정
# 컨테이너 안에서 작업할 기본 폴더를 /usr/src/app으로 설정한다.
WORKDIR /usr/src/app

# 빌드 결과물(.jar)을 컨테이너 안으로 복사
# host의 build/libs 디렉터리에 생성된 JAR 파일을 app.jar로 복사한다.
COPY build/libs/*.jar app.jar

# 컨테이너 실행 시 실행할 명령어 지정
# "java -jar app.jar" 명령으로 스프링 부트 서버 실행
ENTRYPOINT ["java", "-jar", "app.jar"]