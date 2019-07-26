package com.example.springbootdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDockerApplication.class, args);
    }

    @GetMapping
    public List<Per> say() {
        List<Per> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Per(i, "sunny"));
        }
        return list;

    }

    public class Per {
        private Integer id;
        private String name;

        Per(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public Per setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Per setName(String name) {
            this.name = name;
            return this;
        }
    }
}
