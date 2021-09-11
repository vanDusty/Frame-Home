package cn.van.mybatis.batch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2015-2021, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2021/9/10 2:38 下午
 * Description:
 * Version： V1.0
 */

@SpringBootApplication
@MapperScan("cn.van.mybatis.batch.mapper")
public class MybatisDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MybatisDemoApplication.class, args);
    }
}