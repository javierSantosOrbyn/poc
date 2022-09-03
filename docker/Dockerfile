FROM gradle:7.4.2 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle init
RUN gradle build --no-daemon
VERSION=$(gradle printVersion -q)

FROM openjdk:17.0.2-slim

EXPOSE 8080
COPY --from=build *${VERSION}.jar poc-app.jar

USER root
ENTRYPOINT ["java", "-jar", "poc-app.jar"]

