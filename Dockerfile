FROM openjdk:8-jdk-alpine
RUN addgroup -S appuser && adduser -S appuser -G appuser
USER appuser:appuser
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]