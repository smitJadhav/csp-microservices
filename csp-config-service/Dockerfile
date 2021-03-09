FROM openjdk:8u131-jre-alpine
COPY ./target/csp-config-service-*.jar config-service.jar
CMD ["java", "-jar", "-Xmx256m", "config-service.jar"]
