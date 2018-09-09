package io.adonia.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author leo
 * @create 2018/9/9
 */
@Configuration
@MapperScan("io.adonia.springboot.dal")
public class MybatisConfig {
}
