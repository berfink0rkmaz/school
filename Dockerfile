FROM  maven:3.8.5-openjdk-17 AS build
COPY pom.xml .
COPY .mvn .mvn
COPY src src
COPY mvnw .
COPY .idea .idea
COPY .gitignore .
COPY mvnw.cmd .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/school-0.0.1-SNAPSHOT.jar school.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","school.jar"]