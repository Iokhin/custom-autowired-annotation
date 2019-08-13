package ru.iokhin.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.iokhin.annotation.config.Config;
import ru.iokhin.annotation.test.Test;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.getBean(Test.class).test();
    }
}
