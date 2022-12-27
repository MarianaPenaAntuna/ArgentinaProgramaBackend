FROM amazoncorretto:17-alpine-jdk
MAINTAINER marianapena
COPY target/MarianaPena-0.0.1-SNAPSHOT.jar MarianaPena-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MarianaPena-0.0.1-SNAPSHOT.jar"]

