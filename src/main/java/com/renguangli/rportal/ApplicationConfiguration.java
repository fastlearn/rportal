package com.renguangli.rportal;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ApplicationConfiguration
 *
 * @author renguangli 2018/8/2 14:36
 * @since JDK 1.8
 */
@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

    /**
     * 添加未授权跳转页面
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/403").setViewName("error/403");
    }

}
