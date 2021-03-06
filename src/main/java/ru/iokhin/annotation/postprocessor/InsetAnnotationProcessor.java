package ru.iokhin.annotation.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import ru.iokhin.annotation.Inset;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class InsetAnnotationProcessor implements BeanPostProcessor {

    private ApplicationContext context;

    public InsetAnnotationProcessor(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //FIELDS
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(Inset.class) == null) continue;
            field.setAccessible(true);
            Class<?> type = field.getType();
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            //FOR SINGLE GENERIC
            try {
                if (genericType != null) {
                    String[] beanNamesForType = context.getBeanNamesForType(ResolvableType.forClassWithGenerics(type,
                            ((Class) genericType.getActualTypeArguments()[0])));
                    field.set(bean, context.getBean(beanNamesForType[0]));
                }
                else {
                    field.set(bean, context.getBean(type));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //METHODS
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Inset.class) == null) continue;
            method.setAccessible(true);
            Class<?>[] typeParameters = method.getParameterTypes();
            Object[] beans = Arrays.stream(typeParameters).map(context::getBean).toArray();
            try {
                method.invoke(bean, beans);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        Constructor[] constructors = bean.getClass().getConstructors();
        for (Constructor constructor : constructors) {
            if (constructor.getAnnotation(Inset.class) == null) continue;
            constructor.setAccessible(true);
            Class[] parameterTypes = constructor.getParameterTypes();
            Object[] beans = Arrays.stream(parameterTypes).map(context::getBean).toArray();
            try {
                bean = constructor.newInstance(beans);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
