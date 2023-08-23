FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=hotel-app/target/hotel-app.jar

WORKDIR /opt/app

COPY ${JAR_FILE} hotel-service.jar

ENTRYPOINT ["java","-jar","hotel-service.jar"]