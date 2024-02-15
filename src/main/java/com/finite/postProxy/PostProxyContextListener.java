package com.finite.postProxy;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String[] beanDefinitionNames = event.getApplicationContext().getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanDefinitionName);
            Method[] methods = Class.forName(beanDefinition.getBeanClassName()).getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PostProxy.class)) {
                    Object bean = event.getApplicationContext().getBean(beanDefinitionName);
                    bean.getClass().getMethod(method.getName(), method.getParameterTypes()).invoke(bean);
                }
            }
        }
    }
}
