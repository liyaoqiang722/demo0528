package com.wjspc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.wjspc.dao")
public class Demo0528Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0528Application.class, args);
	}
}
