/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MybatisTest
 * Author:   zhangfan
 * Date:     2019-03-29 12:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.mybatis.sharding.demo;
import cn.van.mybatis.sharding.demo.entity.User;
import cn.van.mybatis.sharding.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MultipleDataTest
 * @author: Van
 * Date:     2019-03-26 15:05
 * Description: 测试多数据源配置是否成功
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MultipleDataTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void insert() {
        User userInfo = new User();
        userInfo.setId(2);
        for (int i = 1; i <= 10; i++) {
            userInfo.setId(i);
            userInfo.setUserName("master");
            userInfo.setUserAge(18);
            userMapper.insert(userInfo);
        }
    }
}