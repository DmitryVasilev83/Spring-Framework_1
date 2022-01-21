package ru.geekbrains;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component("cart")
public class Cart {

    List<Product> cartProduct = new ArrayList<>();

    public void putProduct(Product product){
        cartProduct.add(product);
    }

    public void putAllProduct(List<Product> listProduct){
        cartProduct.addAll(listProduct);
    }

    public void deleteProduct(Product product){

        for (int i = 0; i < cartProduct.size(); i++) {
            if (cartProduct.get(i).getId() == product.getId()){
                cartProduct.remove(i);
                break;
            }
        }
    }

    public void deleteProductForId(Product product){

        for (int i = 0; i < cartProduct.size(); i++) {
            if (cartProduct.get(i).getId() == product.getId()){
                cartProduct.remove(i);
            }
            if (i == cartProduct.size()-1){
                break;
            }
        }
    }

    public void clearCart(){
        cartProduct.clear();
    }

    public List<Product> getCartProduct(){
        return cartProduct;
    }
}
