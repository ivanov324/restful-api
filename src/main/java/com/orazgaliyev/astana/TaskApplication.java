package com.orazgaliyev.astana;

import com.orazgaliyev.astana.entity.user.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    private static void simpleModelMappingDemo() {
        UserEntity sourceUser = new UserEntity();
    }

}
