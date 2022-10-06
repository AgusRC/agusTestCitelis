FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
ADD target/agusTestCitelis-0.0.1-SNAPSHOT.jar /opt/app.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]