FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/forum-app.jar /app/forum-app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "forum-app.jar"]
