FROM java:8
MAINTAINER zhaoyunxing
CMD ["java", "-version"]
COPY ./springboot-docker-1.0.jar /app.jar
LABEL version="1.0" app="springboot-docker"
ENTRYPOINT ["java", "-jar", "app.jar"]