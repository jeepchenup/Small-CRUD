package info.chen.smallcrud.configration;

import info.chen.smallcrud.filter.HelloFilter;
import info.chen.smallcrud.interceptor.LoginInterceptor;
import info.chen.smallcrud.listener.HelloListener;
import info.chen.smallcrud.servlet.HelloServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

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

    @Bean
    public ServletRegistrationBean helloServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new HelloServlet());
        servletRegistrationBean.setUrlMappings(Arrays.asList("/helloServlet"));
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean helloFilter(ServletRegistrationBean helloServlet) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HelloFilter(), helloServlet);
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean helloListener() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new HelloListener());

        return servletListenerRegistrationBean;
    }
}
