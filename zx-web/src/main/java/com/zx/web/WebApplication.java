package com.zx.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description 启动文件
 * @Author ZX
 * @Date 11:01 2020/5/9
 * @param
 * @return
 */
@SpringBootApplication(scanBasePackages = {"com.zx"})
@MapperScan({"com.zx.*.dao"})
@EnableTransactionManagement
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
