FROM maven:3.6.3-openjdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:11.0.11-jdk-slim
COPY --from=build /home/app/target/springboot-ms-0.0.1-SNAPSHOT.jar springboot-ms-0.0.1-SNAPSHOT.jar

EXPOSE 8080
EXPOSE 3306

ENTRYPOINT ["java","-jar","springboot-ms-0.0.1-SNAPSHOT.jar"]