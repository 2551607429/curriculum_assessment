//package com.dsa.common.config.cors;
//
//import com.dsa.common.interceptor.CommonInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
///**
// * @author GUOJIKANG
// * @Title:
// * @ClassName WebAppConfigurer
// * @Description: TODO
// * @date 2019/5/29  15:16
// * @Version 1.0
// */
//
//@Configuration
//public class WebAppConfigurer extends WebMvcConfigurationSupport {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry
//                .addMapping("/**")
//                .allowedMethods("*")
//                .allowedOrigins("*")
//                .allowedHeaders("*");
//    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//}
