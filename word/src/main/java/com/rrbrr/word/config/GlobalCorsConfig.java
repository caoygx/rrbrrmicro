package com.rrbrr.word.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 * Created by macro on 2019/7/27.
 */

@Configuration
public class GlobalCorsConfig  implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //registry.addMapping("/tables/list").allowedOrigins("http://tool.rrbrr.com");
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
