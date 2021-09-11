package cn.van.mybatis.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: BaseTest
 *
 * @author: Van
 * Date:     2020-02-02 14:20
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BaseTest {

    @Test
    public void initTest() {
        System.out.println("test");
    }
}