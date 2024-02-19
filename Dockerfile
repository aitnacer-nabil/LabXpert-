FROM openjdk:8-jre-alpine

WORKDIR /app
COPY target/LabXpert-1.0.0.jar /app
EXPOSE 8088

CMD ["java", "-jar", "LabXpert-1.0.0.jar"]
