package com.pjt.tutorin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.pjt.tutorin.model.dao")
@Configuration
public class MybatisConfig {

}
