FROM java:8
MAINTAINER zhaoyunxing
#CMD ["java", "-version"]
#RUN apt update || apt install -y maven
#RUN git clone
#RUN mvn package
COPY /target/springboot-docker.jar /app.jar
LABEL version="1.0" app="springboot-docker"
ENTRYPOINT ["java", "-jar", "app.jar"]