package com.example.springbootdocker;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyunxing
 */
@SpringBootApplication
@RestController
public class SpringbootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerApplication.class, args);
    }

    @GetMapping
    public List<Per> say() {
        List<Per> list = new ArrayList<>();
        list.add(new Per(100, SpringBootVersion.getVersion()));
        for (int i = 0; i < 100; i++) {
            list.add(new Per(i, "sunny" + i));
        }
        return list;
    }

    @Data
    @AllArgsConstructor
    private class Per {
        private Integer id;
        private String name;
    }
}
