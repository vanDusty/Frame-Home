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
package cn.van.mybatis.multipledata.simple;
import cn.van.mybatis.multipledata.simple.entity.UserInfo;
import cn.van.mybatis.multipledata.simple.service.TestService;
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
    TestService testService;

    /**
     * 往主库（master） 新增数据
     */
    @Test
    public void insertMater() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("master");
        userInfo.setPassWord("password");
        userInfo.setUserSex("男");
        testService.insertMater(userInfo);
    }
    /**
     * 往从库（slave） 新增数据
     */
    @Test
    public void insertSlave() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("slave");
        userInfo.setPassWord("password");
        userInfo.setUserSex("女");
        testService.insertSlave(userInfo);
    }
}