package com.zx.common.version;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * api版本控制
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value() default 1;
}
