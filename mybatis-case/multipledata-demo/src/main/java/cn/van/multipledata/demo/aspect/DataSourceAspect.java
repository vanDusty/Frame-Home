package cn.van.multipledata.demo.aspect;

import cn.van.multipledata.demo.annotation.DS;
import cn.van.multipledata.demo.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class DataSourceAspect {

    @Pointcut("@annotation(cn.van.multipledata.demo.annotation.DS)")
    public void dataSourceAspect() {
    }

    @Around("dataSourceAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        boolean clear = true;
        try {
            Method method = this.getMethod(pjp);
            DS DS = method.getAnnotation(DS.class);
            clear = DS.clear();
            DataSourceContextHolder.set(DS.value().getDesc());
            log.info("========数据源切换至：{}", DS.value().getDesc());
            return pjp.proceed();
        } finally {
            if (clear) {
                DataSourceContextHolder.clear();
            }

        }

    }

    private Method getMethod(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        return signature.getMethod();
    }
}
