package cn.van.desensitization.demo;

import cn.van.desensitization.demo.util.DesensitizedUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class DesensitizedUtilsTest {

    @Test
    public void desensitizedFrontField() {
        log.info("chineseName:[{}]", DesensitizedUtil.desensitizedFrontField("风尘博客",2));
        log.info("chineseName:[{}]", DesensitizedUtil.desensitizedFrontField("张凡",1));
    }
    @Test
    public void d() {
        System.out.println("01".substring(1,2));

    }

    @Test
    public void desensitizedBehindField() {
        log.info("desensitizedBehindField:[{}]", DesensitizedUtil.desensitizedBehindField("风尘博客",2));
        log.info("desensitizedBehindField:[{}]", DesensitizedUtil.desensitizedBehindField("张凡",1));
    }

    @Test
    public void desensitizedMiddleField() {
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMiddleField("风尘博客", 1, 1));
        // 脱敏位数超过原字符串长度，无法脱敏
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMiddleField("张凡",4,2));
    }

    @Test
    public void desensitizedMail() {
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMail("123@qq.com"));
        // 脱敏位数超过原字符串长度，无法脱敏
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMail("123sdfsdfds@qq.com"));
    }

    @Test
    public void desensitizedPassword() {
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedPassword("123@qq.com"));
        // 脱敏位数超过原字符串长度，无法脱敏
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedPassword("123sdfsdfds@qq.com"));
    }

    @Test
    public void idCardNum() {
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMiddleField("342523199009120716",2,3));
        log.info("idCardNum:[{}]", DesensitizedUtil.desensitizedMiddleField("34102319900912061X",4,3));
    }

    @Test
    public void fixedPhone() {
        log.info("fixedPhone:[{}]", DesensitizedUtil.desensitizedMiddleField("057460886666",4,2));
        log.info("fixedPhone:[{}]", DesensitizedUtil.desensitizedMiddleField("057160888888",4,2));
    }
}
