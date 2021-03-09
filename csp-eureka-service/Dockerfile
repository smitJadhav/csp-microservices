FROM openjdk:8u131-jre-alpine
COPY ./target/csp-eureka-service-*.jar eureka-service.jar
CMD ["java", "-jar", "-Xmx256m", "eureka-service.jar"]
