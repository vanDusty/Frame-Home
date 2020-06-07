package cn.van.mybatis.pagehelper;

import cn.van.mybatis.pagehelper.entity.UserInfoPagehelperDO;
import cn.van.mybatis.pagehelper.mapper.UserInfoPagehelperMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: MybatisTest
 *
 * @author: Van
 * Date:     2019-07-24 16:15
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MybatisPagehelperTest {

    @Resource
    UserInfoPagehelperMapper userInfoPagehelperMapper;

    @Test
    public void selectForPage() {
        // 第几页
        int currentPage = 2;
        // 每页数量
        int pageSize = 5;
        // 排序
        String orderBy = "id desc";
        PageHelper.startPage(currentPage, pageSize, orderBy);
        List<UserInfoPagehelperDO> users = userInfoPagehelperMapper.selectList();
        PageInfo<UserInfoPagehelperDO> userPageInfo = new PageInfo<>(users);
        log.info("userPageInfo:{}", userPageInfo);
    }

}
