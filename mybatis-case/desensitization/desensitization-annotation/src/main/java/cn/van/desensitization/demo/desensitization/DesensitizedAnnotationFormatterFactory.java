package cn.van.desensitization.demo.desensitization;

import cn.van.desensitization.demo.desensitization.Desensitized;
import cn.van.desensitization.demo.desensitization.DesensitizedFormatter;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: DesensitizedAnnotationFormatterFactory
 *
 * @author: Van
 * Date:     2020-08-02 20:55
 * Description: 实现AnnotationFormatterFactory接口，将带注解的数据脱敏
 * Version： V1.0
 */
public class DesensitizedAnnotationFormatterFactory implements AnnotationFormatterFactory<Desensitized> {

    /**
     * @return 处理的变量的类型
     */
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> hashSet = new HashSet<>();
        hashSet.add(String.class);
        return hashSet;
    }

    @Override
    public Printer<?> getPrinter(Desensitized desensitized, Class<?> aClass) {
        return getFormatter(desensitized);
    }

    @Override
    public Parser<?> getParser(Desensitized desensitized, Class<?> aClass) {
        return getFormatter(desensitized);
    }

    private DesensitizedFormatter getFormatter(Desensitized desensitized) {
        DesensitizedFormatter formatter = new DesensitizedFormatter();
        formatter.setSensitiveTypeEnum(desensitized.type());
        return formatter;
    }

}
