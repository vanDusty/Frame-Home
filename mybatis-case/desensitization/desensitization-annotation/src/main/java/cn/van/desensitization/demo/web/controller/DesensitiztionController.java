package cn.van.desensitization.demo.web.controller;

import cn.van.desensitization.demo.entity.Student;
import cn.van.desensitization.demo.entity.UserInfoDO;
import cn.van.desensitization.demo.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("")
@Slf4j
public class DesensitiztionController {

    @Resource
    UserInfoMapper userInfoMapper;
    @GetMapping("/get")
    public Student get(Student student) {
//        UserInfoDO userInfoDO = userInfoMapper.selectByPrimaryKey(1L);
//        log.info("userInfoDO:{}", userInfoDO);
        return student;
    }
}
