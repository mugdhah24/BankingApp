FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY target/customer-customerService-1.0.0.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]