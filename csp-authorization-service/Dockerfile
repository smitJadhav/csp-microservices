FROM openjdk:8u131-jre-alpine
COPY ./target/csp-authorization-service-*.jar auth-service.jar
CMD ["java", "-jar", "-Xmx256m", "auth-service.jar"]
