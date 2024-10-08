FROM maven:3-eclipse-temurin-17 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

FROM eclipse-temurin:17

COPY --from=build /usr/src/app/target/otel-log-1.0-SNAPSHOT-jar-with-dependencies.jar /otel-log.jar
COPY elastic-otel-javaagent-1.0.0.jar .

CMD ["java", "-javaagent:elastic-otel-javaagent-1.0.0.jar", "-jar", "/otel-log.jar"]