package com.arc.core.config.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 叶超
 * @since 2019/8/12 15:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Note {

    @AliasFor("name")
    String value() default "";


//    @AliasFor("value")
    String name() default "";

    /**
     * 优先级
     *
     * @return int
     */
    int priority() default 0;

}
