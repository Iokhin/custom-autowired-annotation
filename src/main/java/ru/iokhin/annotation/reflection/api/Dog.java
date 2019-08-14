package ru.iokhin.annotation.reflection.api;

import ru.iokhin.annotation.reflection.DogBean;
import ru.iokhin.annotation.reflection.handler.LogHandler;

import java.lang.reflect.Proxy;

public interface Dog {

    static Dog create() {
        final DogBean bean = new DogBean();
        final Class<?>[] dogClass = new Class<?>[] {Dog.class};
        final ClassLoader classLoader = Dog.class.getClassLoader();
        final LogHandler handler = new LogHandler(bean);
        return (Dog) Proxy.newProxyInstance(classLoader, dogClass, handler);
    }

    void run();

    void bark();

    void sleep();

}
