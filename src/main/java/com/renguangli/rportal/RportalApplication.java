package com.renguangli.rportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.renguangli.rportal.mapper"})
public class RportalApplication {

    public static ApplicationContext ctx;

	public static void main(String[] args) {
        ctx = SpringApplication.run(RportalApplication.class, args);
    }
}
