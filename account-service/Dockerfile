FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY target/account-service-1.0.0.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]