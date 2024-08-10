FROM openjdk:17-jdk-alpine

RUN mkdir /app

WORKDIR /app

COPY target/quadrodenotas-0.0.1.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]