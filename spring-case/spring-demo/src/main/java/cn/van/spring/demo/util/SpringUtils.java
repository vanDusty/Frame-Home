package cn.van.spring.demo.util;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @公众号： 风尘博客
 * @Classname SpringUtils
 * @Description  Spring ApplicationContext 工具类
 * @Date 2020/1/3 4:32 下午
 * @Author by Van
 */
@Component
public final class SpringUtils implements ApplicationContextAware {
    /**
     * Spring应用上下文环境
     */
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 获取对象，重写了bean方法
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return SpringUtils.applicationContext.getBean(clazz);
    }

    /**
     * 同上方法
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return SpringUtils.applicationContext.getBean(name);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * @param name
     * @return
     */
    public static boolean containsBean(String name) {
        return SpringUtils.applicationContext.containsBean(name);
    }
    /**
     * 读取配置信息
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return SpringUtils.applicationContext.getEnvironment().getProperty(key);
    }

    /**
     * 该方法直接将 ApplicationContext 直接返回，需要什么方法，直接从该接口获取。
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
