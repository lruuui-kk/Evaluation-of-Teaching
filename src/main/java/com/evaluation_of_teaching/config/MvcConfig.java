package com.evaluation_of_teaching.config;

import com.evaluation_of_teaching.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//过滤所有请求
                .excludePathPatterns("/index.html","/","/login","/css/*","/js/**","/img/**","/login");//除了这些
    }
}
