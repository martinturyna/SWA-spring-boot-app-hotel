FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=hotel-app/target/hotel-app.jar

WORKDIR /opt/app

COPY ${JAR_FILE} customer-profile-service.jar

ENTRYPOINT ["java","-jar","customer-profile-service.jar"]