# 使用前先执行：mvn package 生成jar文件
FROM java:8
MAINTAINER zhaoyunxing
WORKDIR /app

COPY /target/springboot-docker.jar ./springboot-docker.jar
LABEL version="1.0" \
      app="springboot-docker" \
      desc="docker for spring boot demo"
# 解决时区问题
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' > /etc/timezone
RUN date

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "./springboot-docker.jar"]