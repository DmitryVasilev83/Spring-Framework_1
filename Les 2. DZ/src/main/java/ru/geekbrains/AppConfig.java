package ru.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.geekbrains")
public class AppConfig {

    @Bean(name = "product")
    public ProductRepository productRepository() {
        return new ProductRepository() ;
    }

    @Bean(name = "cart")
    public Cart cart(){
        Cart cart = new Cart();

        return cart;
    }

}
