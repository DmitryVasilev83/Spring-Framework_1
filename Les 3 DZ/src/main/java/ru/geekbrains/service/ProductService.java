package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repozitory.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;

    public Product createProduct(Product product){return productRepository.createProduct(product); }

    public List<Product> getProductList(){
        return productRepository.getProductList();
    }

    public Product findProductById(Integer id){
        return productRepository.findProductById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteProductById(Integer id){productRepository.deleteProductByID(id);
    }



}
