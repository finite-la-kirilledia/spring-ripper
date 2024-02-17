package com.finite.deprecatedClass;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecatedClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            Class<?> originalBeanClass = Class.forName(beanDefinition.getBeanClassName());

            DeprecatedClass annotation = originalBeanClass.getAnnotation(DeprecatedClass.class);
            if (annotation != null) {
                beanDefinition.setBeanClassName(annotation.newImpl().getName());
            }
        }
    }
}
