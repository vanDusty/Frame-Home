package cn.van.spring.copy;

import cn.van.spring.copy.common.SexEnum;
import cn.van.spring.copy.entity.UserDO;
import cn.van.spring.copy.model.UserVO;
import cn.van.spring.copy.util.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: BeanUtilsTest
 *
 * @author: Van
 * Date:     2020-01-08 11:13
 * Description: ${DESCRIPTION}
 * Version： V1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BeanUtilsTest {

    /**
     * 单个对象拷贝
     */
    @Test
    public void commonCopy() {
        UserDO userDO = new UserDO(1L, "Van", 18, 1);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        log.info("userVO:{}",userVO);
    }

    /**
     * 集合拷贝（错误）
     */
    @Test
    public void listCopyFalse() {
        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 18, 2));
        List<UserVO> userVOList = new ArrayList();
        BeanUtils.copyProperties(userDOList, userVOList);
        log.info("userVOList:{}",userVOList);
    }

    /**
     * 暴力的集合拷贝
     */
    @Test
    public void listCopyCommon() {
        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 20, 2));
        List<UserVO> userVOList = new ArrayList();
        userDOList.forEach(userDO ->{
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userDO, userVO);
            userVOList.add(userVO);
        });
        log.info("userVOList:{}",userVOList);
    }

    /**
     * 集合拷贝
     */
    @Test
    public void listCopyUp() {
        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 20, 2));
        List<UserVO> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO::new);
        log.info("userVOList:{}",userVOList);
    }

    /**
     * 带回调的拷贝
     */
    @Test
    public void listCopyUpWithCallback() {
        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 20, 2));
        List<UserVO> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO::new, (userDO, userVO) -> {
            // 这里可以定义特定的转换规则
            userVO.setSex(SexEnum.getDescByCode(userDO.getSex()).getDesc());
        });
        log.info("userVOList:{}",userVOList);
    }

}
