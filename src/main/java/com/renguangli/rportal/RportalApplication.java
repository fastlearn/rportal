package com.renguangli.rportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.renguangli.rportal.mapper"})
public class RportalApplication extends SpringBootServletInitializer {

    public static ApplicationContext ctx;

	public static void main(String[] args) {
        ctx = SpringApplication.run(RportalApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RportalApplication.class);
    }
}
