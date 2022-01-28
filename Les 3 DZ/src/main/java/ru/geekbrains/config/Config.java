package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.geekbrains.repozitory.ProductRepository;

@Configuration
@ComponentScan("ru.geekbrains")
@EnableWebMvc
public class Config {

//    @Bean(name = "product")
//    public ProductRepository productRepository() {
//        return new ProductRepository() ;
//    }

    public static final String RESOLVER_PREFIX = "WEB-INF/view/";
    public static final String RESOLVER_SUFFIX = ".jsp";

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);
        return viewResolver;
    }

}
