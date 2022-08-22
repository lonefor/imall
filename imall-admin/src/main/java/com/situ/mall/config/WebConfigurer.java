package com.situ.mall.config;

import com.situ.mall.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration用于定义配置类，可以替换xml配置文件，
// 加了这个注解的类的内部包含一个或多个被@Bean注解的方法
//@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /*<!-- 配置拦截器 -->
      <mvc:interceptors>
         <mvc:interceptor>
            <mvc:mapping path="/**"/>
            <mvc:exclude-mapping path=""/>
            <bean class="com.situ.mvc.interceptor.MyInterceptor1"></bean>
         </mvc:interceptor>
      </mvc:interceptors>*/
    // 这个方法用来注册拦截器，我们写的拦截器需要在这里配置才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求
        // excludePathPatterns()   代表排除哪些请求不需要拦截
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/getLoginPage", "/auth/code", "/error", "/static/**");
    }
}
