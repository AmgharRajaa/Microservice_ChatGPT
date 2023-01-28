FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/SpringAPI-O.O.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]