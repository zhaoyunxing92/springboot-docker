FROM java:8
MAINTAINER zhaoyunxing
CMD ["java", "-version"]
RUN sudo yum install -y maven
RUN mvn package
COPY /target/springboot-docker.jar /app.jar
LABEL version="1.0" app="springboot-docker"
ENTRYPOINT ["java", "-jar", "app.jar"]