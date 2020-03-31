FROM openjdk:11.0.6-slim
EXPOSE 8080
COPY target/demo*.jar /opt/demo-app/lib/demo-app.jar
ENTRYPOINT ["java"]
CMD ["-jar", "/opt/demo-app/lib/demo-app.jar"]