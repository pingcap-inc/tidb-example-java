package com.pingcap.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pingcap.example")
public class TiDBSpringBootMyBatisServerlessExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiDBSpringBootMyBatisServerlessExampleApplication.class, args);
    }

}
