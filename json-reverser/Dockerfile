FROM adoptopenjdk/openjdk11:alpine
RUN mkdir /opt/app
COPY target/json-reverser.jar /opt/app
CMD ["java", "-jar", "/opt/app/json-reverser.jar"]