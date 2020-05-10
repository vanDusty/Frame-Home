/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserApplication
 * Author:   zhangfan
 * Date:     2019-01-29 17:09
 * Description: 用户模块启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.transaction.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MybatisDemoApplication
 *
 * @author: Van
 * Date:     2019-07-26 22:05
 * Description: 启动类
 * Version： V1.0
 */
@SpringBootApplication
@MapperScan("cn.van.transaction.demo.mapper")
public class TransactionDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(TransactionDemoApplication.class, args);
    }
}