package cn.van.desensitization.demo.web.controller;

import cn.van.desensitization.demo.entity.Student;
import cn.van.desensitization.demo.entity.UserInfoDO;
import cn.van.desensitization.demo.mapper.UserInfoMapper;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("")
@Slf4j
public class DesensitiztionController {

    @Resource
    UserInfoMapper userInfoMapper;
    @GetMapping("/get")
    public Student get(Student student) {
        log.info("[{}]",student);
//        UserInfoDO userInfoDO = userInfoMapper.selectByPrimaryKey(1L);
//        log.info("userInfoDO:{}", userInfoDO);
        return student;
    }

    @PostMapping("/post")
    public UserInfoDO post(UserInfoDO userInfoDO) {
        log.info("user[{}]", userInfoDO);
//        UserInfoDO userInfoDO = new UserInfoDO();
//        userInfoDO.setUserName("张三");
//        userInfoDO.setNickName("Van");
//        userInfoDO.setBankCard("6222021317004132269");
//        userInfoDO.setEmail("1251787298@qq.com");
//        userInfoDO.setGmtCreate(LocalDateTime.now());
//        userInfoDO.setId(1L);
//        userInfoDO.setMobile("13966666666");
//        userInfoDO.setTelNumber("057169762313");
//        userInfoDO.setCarNumber("浙ABC888");
        return userInfoDO;    }
}
