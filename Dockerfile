#Build
FROM maven:3.6-jdk-8-alpine AS builder
RUN apk add --update --no-cache git
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package

#Run Spring Boot
FROM openjdk:8
VOLUME /tmp
COPY --chown=10004:10004 --from=builder /app/target/*.jar /app/app.jar
EXPOSE 8080
USER 10004:10004
WORKDIR /app
CMD java -jar app.jar