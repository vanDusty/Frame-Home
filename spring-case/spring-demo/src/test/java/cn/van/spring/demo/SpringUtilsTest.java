package cn.van.spring.demo;

import cn.van.spring.demo.util.SpringBean;
import cn.van.spring.demo.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.web.context.ContextLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.*;

/**
 * @公众号： 风尘博客
 * @Classname StopWatchTest
 * @Description StopWatch 示例
 * @Date 2020/1/2 11:35 上午
 * @Author by Van
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SpringUtilsTest {

    @Test
    public void getBeanDemo() {
        SpringBean springBean = SpringUtils.getBean(SpringBean.class);
        log.info("springBean.desc:{}", springBean.getDesc());
        // 如果bean 不存在
        log.info("springBeanOther:{}", SpringUtils.getBean("springBeanOther"));
    }

    @Test
    public void containsBeanDemo() {
        log.info("containsBean:{}", SpringUtils.containsBean("springBean"));
        // 如果bean 不存在
        log.info("containsBean:{}", SpringUtils.containsBean("springBeanOther"));
    }

    @Test
    public void getPropertyDemo() {
        String value = SpringUtils.getProperty("demo.value");
        log.info("value:{}", value);
        // 配置中不存在
        String key = SpringUtils.getProperty("demo.key");
        log.info("key:{}", key);
    }

    @Test
    public void getApplicationContext() {
        ApplicationContext context = SpringUtils.getApplicationContext();
        log.info("context.containsBean():{}", context.containsBean("springBean"));
    }
}
