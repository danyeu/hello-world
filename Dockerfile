FROM azul/zulu-openjdk-distroless:21-latest

COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]