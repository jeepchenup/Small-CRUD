package info.chen.smallcrud.configration;

import info.chen.smallcrud.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebApplicationConfigration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.*").setViewName("login");
        registry.addViewController("/home").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       /* registry.addInterceptor(new LoginInterceptor())
                 .addPathPatterns("/**")
                 .excludePathPatterns("/", "/index", "/index.*", "/login", "/asserts/**", "/webjars/**");*/
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new CustomLocaleResolver();
    }
}
