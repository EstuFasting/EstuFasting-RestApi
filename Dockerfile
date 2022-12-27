FROM maven:3.8.2-jdk-17 AS build
COPY . .
RUN mvn clean package -Pprod

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]