package com.sucl.smms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 排除的时候还需要排除其他@ComponentScan的类
 * 比如类A和类B都配置了@ComponentScan，那么回去合集
 * @author sucl
 * @since 2019/3/21
 */
@Configuration
@ComponentScan(value = "com.sucl.smms",useDefaultFilters = true,
                excludeFilters = {
                    @ComponentScan.Filter({Controller.class,ControllerAdvice.class})
//                    ,@ComponentScan.Filter(type = FilterType.CUSTOM,classes = ConsumTypeFilter.class)
                    ,@ComponentScan.Filter(type = FilterType.REGEX,pattern = ".*\\.config\\.ServletConfig")
                }
            )
public class RootConfig {
}
