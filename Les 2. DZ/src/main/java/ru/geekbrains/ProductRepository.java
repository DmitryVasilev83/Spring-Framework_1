package ru.geekbrains;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("product")
public class ProductRepository implements ProductRep{

    List<Product> listProduct = new ArrayList<>();

    public ProductRepository() {
        listProduct.add(new Product(1, "title_1", 100));
        listProduct.add(new Product(2, "title_2", 200));
        listProduct.add(new Product(3, "title_3", 300));
        listProduct.add(new Product(4, "title_4", 400));
        listProduct.add(new Product(5, "title_5", 500));

    }

    public Product getProduct(int idProd){
        for (int i = 0; i < listProduct.size(); i++) {
            if (idProd == listProduct.get(i).getId()){
                return listProduct.get(i);
            }
        }
        return null;
    }

    public List<Product> getListProduct(){
        return listProduct;
    }
}
