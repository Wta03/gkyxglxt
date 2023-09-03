package com.qust.task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qust.task.mapper")
public class MedicalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalApplication.class, args);
    }

}
