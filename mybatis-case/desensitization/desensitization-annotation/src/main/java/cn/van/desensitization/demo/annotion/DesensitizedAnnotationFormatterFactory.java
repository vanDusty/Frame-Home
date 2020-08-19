package cn.van.desensitization.demo.annotion;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

/**
 * Deprecated为注解的名称
 *
 * @author 韩惠德
 */
public class DesensitizedAnnotationFormatterFactory implements AnnotationFormatterFactory<Desensitized> {
    /**
     * 返回为处理的变量的类型
     *
     * @return
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
        formatter.setTypeEnum(desensitized.type());
        return formatter;
    }

}
