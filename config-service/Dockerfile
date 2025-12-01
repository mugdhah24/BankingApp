FROM eclipse-temurin:22-jdk-alpine
WORKDIR /app
COPY target/config-service-1.0.0.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","app.jar"]
