package com.tensquare.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * 功能描述:
 *
 * @作者: lj
 * @创建时间: 2019/5/9 17:12
 */
@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    //注册IdWorker
    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
