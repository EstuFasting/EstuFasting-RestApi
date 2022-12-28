FROM maven:3.8.6-openjdk-18-slim AS build
COPY . .
RUN mvn clean package -Pprod

FROM openjdk:18-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]