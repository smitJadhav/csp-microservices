FROM openjdk:8u131-jre-alpine
COPY ./target/csp-gateway-service-*.jar gateway-service.jar
CMD ["java", "-jar", "-Xmx256m", "gateway-service.jar"]
