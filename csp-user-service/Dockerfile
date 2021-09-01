FROM openjdk:8u131-jre-alpine
COPY ./target/csp-user-service-*.jar user-service.jar
CMD ["java", "-jar", "-Xmx256m", "user-service.jar"]
