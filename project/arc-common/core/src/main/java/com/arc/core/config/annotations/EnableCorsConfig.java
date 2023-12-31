package com.arc.core.config.annotations;

import com.arc.core.config.configurations.cors.CorsConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 允许 所有的 跨域
 * EnableCorsConfig 的配置作为注解引入到您需要的项目中去
 *
 * @author yechao
 * @since 2019/10/23 17:17
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CorsConfig.class)
@Documented
public @interface EnableCorsConfig {

}
