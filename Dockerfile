# Build stage
FROM ubuntu:latest AS build
LABEL authors="Ördög Szabolcs"

RUN apt-get update
RUN apt-get install openjdk-17-jdk maven -y

WORKDIR /app
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-slim
EXPOSE 8082

WORKDIR /app
COPY --from=build /app/target/webshop-v1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
