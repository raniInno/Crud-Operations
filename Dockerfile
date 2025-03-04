FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/spring-boot-docker.jar
ADD target/spring-boot-docker.jar /aap.jar
#COPY spring-boot-docker.jar spring-boot-docker.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]