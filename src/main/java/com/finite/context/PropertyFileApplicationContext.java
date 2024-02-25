package com.finite.context;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int numberOfBeanDefinitions = reader.loadBeanDefinitions(fileName);
        System.out.printf("Found %s bean definition(s)\n", numberOfBeanDefinitions);
        refresh();
    }
}
