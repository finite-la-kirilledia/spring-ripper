package com.finite.injectRandomInt;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

    int min() default 1;

    int max() default 1;
}
