# springboot-docker

使用[docker-maven-plugin](https://github.com/spotify/docker-maven-plugin)插件构建docker版的springboot服务

## 配置说明

* 切换工作目录在 `app`
* mv jar到app目录下
* 解决docker时区问题

```xml
<build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>com.spotify</groupId>
                <artifactId>docker-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <imageName>${project.build.finalName}:${project.version}</imageName>
                    <workdir>/app</workdir> <!--指定工作目录-->
                    <forceTags>false</forceTags>
                    <baseImage>java</baseImage>
                    <!--<exposes>-->
                    <!--<expose>8080</expose>-->
                    <!--</exposes>-->
                    <!-- copy the service's jar file from target into the root directory of the image -->
                    <resources>
                        <resource>
                            <targetPath>/</targetPath>
                            <directory>${project.build.directory}</directory>
                            <include>${project.build.finalName}.jar</include>
                        </resource>
                    </resources>
                    <runs>
                        <run>mv /${project.build.finalName}.jar ./</run> <!--复制文件到工作目录-->
                        <run>cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime</run>
                        <run>echo 'Asia/Shanghai' > /etc/timezone</run> <!-- 解决时区问题 -->
                        <run>date</run>
                        <!--<run>chmod 755 *</run>-->
                    </runs>
                    <entryPoint>["java", "-jar", "${project.build.finalName}.jar","--spring.profiles.active=local"]</entryPoint>
                </configuration>
            </plugin>
        </plugins>
    </build>
```