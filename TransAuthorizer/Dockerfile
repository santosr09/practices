FROM openjdk:11.0.7-slim
COPY /target/TransAuthorizer-1.0-SNAPSHOT.jar /usr/local/app/
WORKDIR /usr/local/app/
ENTRYPOINT ["java", "-jar", "TransAuthorizer-1.0-SNAPSHOT.jar"]