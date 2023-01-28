
# Java Microservice ChaGPT 

### Swagger UI
`Post /api/Askchatgpt/send`

![App Screenshot](https://i.postimg.cc/gj3xgS7v/2023-01-28-04-07-18-1.gif)

- CSV file
`/api/Askchatgpt/export-to-csv`

![App Screenshot](https://i.postimg.cc/Yqy8dnLm/2023-01-28-14-20-34.gif)

## Description

This is a [Springboot3](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/) project that implements the microservice architecture [(RESTAPI)](https://www.ibm.com/docs/en/mam/7.6.0?topic=applications-rest-api) , allowing communication with the ChatGPT API using the completion model (text-davinci-003). This microservice sends an HTTP request with the question in JSON format as a parameter and receives a response from the API.


## Project Dependencies

- Lombok
```java
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```
- Spring web
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- springdoc-openapi
```java
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.2</version>
</dependency>
```
- h2-database
```java
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```
- Apache Common CSV library
```java
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-csv</artifactId>
    <version>1.8</version>
</dependency>
```
- Spring data jpa
```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```


## ChatGPT Configuration

```java
public class ChatGptConfig {
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String API_KEY = "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";
    public static final String MODEL = "text-davinci-003";
    public static final Integer MAX_TOKEN = 300;
    public static final Double TEMPERATURE = 0.0;
    public static final Double TOP_P = 1.0;
    public static final String MEDIA_TYPE = "application/json; charset=UTF-8";
    public static final String URL = "https://api.openai.com/v1/completions";
}
```


## Project Structure

![App Screenshot](https://i.postimg.cc/T1ZnGmcT/Capture.png)

#### - Package Config: contains the necessary configuration for connecting to the ChatGPT API.
#### - Package controller: contains the "sendMessage" method that sends an HTTP request and receives a response from ChatGPT.
#### - Package Model: contains the data (response/request) to be managed for our microservice.
#### - Package service: contains the implementation of our "sendMessage" method and handles the business logic.

## Docker Configuration
#### - create Dockerfile
```http
FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/SpringAPI-O.O.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
#### - build image for microservice api
```http
 docker build -t microservicechatgpt .
```
![App Screenshot](https://i.postimg.cc/sxHXYRLx/Capture.png)


