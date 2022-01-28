package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.HelloConfiguration;

import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        for (int i = 0; i < 5; i++) {
            MessageRender messageRender = context.getBean(MessageRender.class);
            messageRender.render();
        }

        context.close();

    }
}