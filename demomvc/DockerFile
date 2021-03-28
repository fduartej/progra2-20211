FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY target/*.jar app.jar
ENTRYPOINT ["java","-Xmx300m -jar","/app.jar"]