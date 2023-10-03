# Build stage
FROM gradle:jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon
LABEL org.name="nassa"

# Package stage
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /home/gradle/src/build/libs/nassa-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
