FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
RUN apt-get -y update && apt-get install -y maven
RUN ./mvnw package && java -jar ${JAR_FILE}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]