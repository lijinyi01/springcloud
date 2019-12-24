package com.web.springboot.config;

import com.web.springboot.component.LoginHandlerInterceptor;
import com.web.springboot.component.MyLocaleResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Controller
public class MyConfig extends WebMvcConfigurerAdapter {
  //  @Bean
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        registry.addViewController("/haha").setViewName("login");
    }

    @Bean
    public WebMvcConfigurerAdapter  webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                 registry.addViewController("/lanjieqi") .setViewName("index");
            }
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login","/emps");
                // super.addInterceptors(registry);
            }

        };
        return adapter;
    }



    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
