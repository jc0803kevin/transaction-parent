package com.kevin.trans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author kevin
 * @Description
 * @Date Created on 2020/5/25 14:10
 */

@SpringBootApplication(scanBasePackages =  {"com.kevin.trans"})
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)
@MapperScan(basePackages = {"com.kevin.trans.mapper"})
@EnableTransactionManagement
public class TransApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransApplication.class, args);
    }
}
