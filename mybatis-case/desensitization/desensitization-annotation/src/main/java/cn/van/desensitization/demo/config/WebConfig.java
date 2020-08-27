package cn.van.desensitization.demo.config;
import cn.van.desensitization.demo.desensitization.DesensitizedAnnotationFormatterFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        log.info("启用自定义注解[Desensitized}]");
        registry.addFormatterForFieldAnnotation(new DesensitizedAnnotationFormatterFactory());
    }
}
