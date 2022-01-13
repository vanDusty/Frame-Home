package cn.van.mybatis.pagination;

import cn.van.mybatis.pagination.entity.UserInfoDO;
import cn.van.mybatis.pagination.page.MybatisPageInterceptor;
import cn.van.mybatis.pagination.mapper.UserMapper;
import cn.van.mybatis.pagination.page.PageResult;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
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
 * FileName: MybatisPaginationTest
 *
 * @author: Van
 * Date:     2019-06-24 16:15
 * Description: 分页测试
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MybatisPaginationTest {

    @Resource
    private UserMapper userMapper;

    /**
     * PageHelper 分页
     */
//    @Test
//    public void pagehelperTest() {
//        // 普通查询
//        List<UserInfoDO> list = userMapper.findAll();
//        log.info("list:{}", list);
//
//        // PageHelper 插件分页查询
//        // 第几页
//        int currentPage = 1;
//        // 每页数量
//        int pageSize = 4;
//        // 排序
//        String orderBy = "id desc";
//        PageHelper.startPage(currentPage, pageSize, orderBy);
//        List<UserInfoDO> users = userMapper.findAll();
//        PageInfo<UserInfoDO> pageInfo = new PageInfo<>(users);
//        log.info("pageInfo:{}", pageInfo);
//    }

    /**
     * 拦截器分页
     */
    @Test
    public void interceptorTest() {
        // 普通查询
        List<UserInfoDO> list = userMapper.findAll();
        log.info("list:{}", list);

        // PageHelper 插件分页查询
        // 第几页
        int currentPage = 1;
        // 每页数量
        int pageSize = 4;
        // 该查询进行分页，指定第几页和每页数量
        MybatisPageInterceptor.startPage(currentPage, pageSize);
        List<UserInfoDO> all = userMapper.findAll();
        PageResult<UserInfoDO> result = new PageResult<>(all);
        log.info("result:{}", result);
    }
}