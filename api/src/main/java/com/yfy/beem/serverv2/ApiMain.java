package com.yfy.beem.serverv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApiMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ApiMain.class);

    }
}
