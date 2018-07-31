package com.renguangli.rportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RportalApplication {

    public static ApplicationContext ctx;

	public static void main(String[] args) {
        ctx = SpringApplication.run(RportalApplication.class, args);
    }
}
