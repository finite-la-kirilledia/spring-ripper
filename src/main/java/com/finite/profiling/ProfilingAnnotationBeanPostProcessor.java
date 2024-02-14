package com.finite.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class ProfilingAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.printf("Start profiling %s.%s()\n", bean.getClass().getSimpleName(), method.getName());

                long startTime = System.nanoTime();
                Object result = method.invoke(bean, args);
                long endTime = System.nanoTime();

                System.out.printf("Done profiling %s.%s() result=%s nanoseconds\n", bean.getClass().getSimpleName(), method.getName(), endTime - startTime);

                return result;
            });
        }
        return bean;
    }
}
