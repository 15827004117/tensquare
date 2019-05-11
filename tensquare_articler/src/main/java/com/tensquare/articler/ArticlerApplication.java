package com.tensquare.articler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


@SpringBootApplication
public class ArticlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlerApplication.class, args);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
