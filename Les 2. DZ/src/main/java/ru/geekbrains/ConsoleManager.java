package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ConsoleManager {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("product",ProductRepository.class);

        Cart cart = context.getBean("cart", Cart.class);
        cart.putProduct(productRepository.getProduct(1));
        cart.putProduct(productRepository.getProduct(3));
        cart.putProduct(productRepository.getProduct(5));
        cart.putAllProduct(productRepository.getListProduct());

        cart.deleteProduct(productRepository.getProduct(3));
        cart.deleteProductForId(productRepository.getProduct(5));

        printCartProduct(cart.getCartProduct());

//        cart.clearCart();
//        System.out.println("clear");
//        printCartProduct(cart.getCartProduct());

        Cart cart1 = context.getBean("cart", Cart.class);
        printCartProduct(cart1.getCartProduct());  // новая корзина пуста

    }

    private static void printCartProduct(List<Product> cartProduct) {

        for (Product product: cartProduct) {
            System.out.println(product.getId() + " " + product.getTitle() + " " + product.getCost());
        }


    }


}
