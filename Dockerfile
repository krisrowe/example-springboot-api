# syntax=docker/dockerfile:1

#FROM openjdk:11

#WORKDIR /app

#COPY .mvn/ .mvn 
#COPY mvnw pom.xml ./
#COPY pom.xml ./pom.xml
#RUN ./mvnw dependency:go-offline

#COPY src ./src
#CMD ["./mvnw", "spring-boot:run"]


FROM maven:3.6.3-jdk-11 as builder

# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY src ./src

# Build a release artifact.
RUN mvn package 

FROM adoptopenjdk/openjdk11:alpine-jre

COPY --from=builder /app/target/*.jar /java.jar

# Run the web service on container startup.
CMD ["java","-jar","/java.jar"]
