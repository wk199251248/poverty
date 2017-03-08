package com.myproject.poverty.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by miracle on 2017/2/28.
 */
@ComponentScan
@ServletComponentScan
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableCaching
public class ConsoleApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsoleApplication.class,args);
    }
}
