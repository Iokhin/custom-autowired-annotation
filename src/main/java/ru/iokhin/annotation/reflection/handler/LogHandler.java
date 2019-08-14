package ru.iokhin.annotation.reflection.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler {

    static final Logger LOGGER = Logger.getGlobal();

    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info(proxy.getClass().getName() + "::" + method.getName());
        return method.invoke(target, args);
    }
}
