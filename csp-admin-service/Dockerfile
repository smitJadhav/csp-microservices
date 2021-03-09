FROM openjdk:8u131-jre-alpine
COPY ./target/csp-admin-service-*.jar admin-service.jar
CMD ["java", "-jar", "-Xmx256m", "admin-service.jar"]
