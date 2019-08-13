package ru.iokhin.annotation.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.iokhin.annotation.postprocessor.InsetAnnotationProcessor;

@Configuration
@ComponentScan("ru.iokhin")
public class Config implements ApplicationContextAware {

    private ApplicationContext context;

    @Bean
    InsetAnnotationProcessor getInsetAnnotationProcessor() {
        return new InsetAnnotationProcessor(context);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
