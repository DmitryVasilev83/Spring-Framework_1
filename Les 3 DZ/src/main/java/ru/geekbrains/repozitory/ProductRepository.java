package ru.geekbrains.repozitory;


import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("product")
public class ProductRepository {

    List<Product> productList = new ArrayList<>();
    private int count = 0;

    public Product createProduct(Product product){
        product.setId(count++);
        productList.add(product);

        // заворачиваем в билдер(из ломбока) для безопасности. ВОзвращаем не само сообщение а его копию

        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .cost(product.getCost())
                .build();
    }

    public List<Product> getProductList(){
        return new ArrayList<>(productList);
    }

    public Optional<Product> findProductById(Integer id){
        if (id < productList.size()){
            return Optional.of(productList.get(id));
        }else {
            return Optional.empty();
        }
    }

    public void deleteProductByID(Integer id){
        if (id < productList.size()){
            productList.remove(id.intValue());
        }
    }

}
