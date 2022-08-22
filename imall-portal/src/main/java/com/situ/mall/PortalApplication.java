package com.situ.mall;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

// 声明该类是一个SpringBoot的引导类
@SpringBootApplication
// @MapperScan注解，扫描MyBatis Mapper接口类
@MapperScan("com.situ.mall.mapper")
public class PortalApplication {
    private static final Logger LOG = LoggerFactory.getLogger(PortalApplication.class);

    public static void main(String[] args) {
        // SpringApplication.run(WikiApplication.class, args);
        SpringApplication app = new SpringApplication(PortalApplication.class);
        Environment environment = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址:\thttp://127.0.0.1:{}", environment.getProperty("server.port"));
    }


}