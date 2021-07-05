FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /opt/app
COPY target/json-server.jar /opt/app
CMD ["java", "-jar", "/opt/app/json-server.jar"]