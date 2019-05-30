package com.dwsp.lock.annotation;

import sun.rmi.runtime.Log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {

    String[] keys() default {""};

    long expire() default 30000L;

    long timeout() default 3000L;
}
