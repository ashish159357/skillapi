FROM openjdk:8u171-jre-alpine
COPY target/*.jar app.jar
CMD ["java","-jar","app.jar"]
