package com.personalprojects.java_commerce.configuration;

import com.personalprojects.java_commerce.DB;
import com.personalprojects.java_commerce.DevDB;
import com.personalprojects.java_commerce.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "develop")
    public DB getDevDBBean() {
        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "prod")
    public DB getProdDBBean() {
        return new ProdDB();
    }
}
