package cn.van.mybatis.pageable;

import cn.van.mybatis.pageable.entity.UserInfoDO;
import cn.van.mybatis.pageable.page.PageInterceptor;
import cn.van.mybatis.pageable.mapper.UserMapper;
import cn.van.mybatis.pageable.page.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MybatisPageableTest
 *
 * @author: Van
 * Date:     2019-06-24 16:15
 * Description: 分页测试
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MybatisPageableTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<UserInfoDO> list = userMapper.findAll();
        log.info("list:{}", list);
    }

    @Test
    public void selectForPage() {
        // 该查询进行分页，指定第几页和每页数量
        PageInterceptor.startPage(1,4);
        List<UserInfoDO> all = userMapper.findAll();
        PageResult<UserInfoDO> result = new PageResult<>(all);
        // 分页结果打印
        log.info("总记录数：{}", result.getTotalSize());
        log.info("list：{}", result.getData());
        log.info("result:{}", result);
    }
}
