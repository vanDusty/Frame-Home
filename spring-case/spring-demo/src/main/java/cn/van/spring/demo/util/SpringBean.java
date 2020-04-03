package cn.van.spring.demo.util;

import org.springframework.stereotype.Component;

/**
 * @公众号： 风尘博客
 * @Classname SpringBean
 * @Description 被Spring 管理的 Bean
 * @Date 2020/1/3 4:35 下午
 * @Author by Van
 */
@Component
public class SpringBean {

    private String desc;

    public String getDesc() {
        return "SpringBean desc";
    }
}
