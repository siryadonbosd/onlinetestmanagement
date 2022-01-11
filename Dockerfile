FROM openjdk:8-jdk-alpine
MAINTAINER experto.com
VOLUME /tmp
EXPOSE 8080
ADD build/libs/*.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-jar","/springbootpostgresqldocker.jar"]
