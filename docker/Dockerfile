FROM java:8
MAINTAINER zhaoyunxing
CMD ["java", "-version"]
WORKDIR /app
COPY ./springboot-docker.jar /app/springboot-docker.jar
LABEL version="1.0" app="springboot-docker"
ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]