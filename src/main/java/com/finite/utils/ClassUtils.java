package com.finite.utils;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

@UtilityClass
public class ClassUtils {

    public static Class<?>[] getAllInheritedInterfaces(Class<?> clazz) {
        Stack<Class<?>> stack = new Stack<>();
        Set<Class<?>> allInheritedInterfaces = new HashSet<>();

        stack.push(clazz);
        while (!stack.isEmpty()) {
            Class<?> currentClass = stack.pop();

            Class<?> superClass = currentClass.getSuperclass();
            if (superClass != null) {
                stack.push(superClass);
            }

            for (var i : currentClass.getInterfaces()) {
                stack.push(i);
                allInheritedInterfaces.add(i);
            }
        }

        return allInheritedInterfaces.toArray(new Class[0]);
    }
}
