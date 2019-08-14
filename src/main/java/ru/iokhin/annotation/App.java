package ru.iokhin.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.iokhin.annotation.config.Config;
import ru.iokhin.annotation.test.lists.ListTest;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ListTest bean = context.getBean(ListTest.class);
        System.out.println(bean.strings.size());
        System.out.println(bean.integers.size());
    }
}
