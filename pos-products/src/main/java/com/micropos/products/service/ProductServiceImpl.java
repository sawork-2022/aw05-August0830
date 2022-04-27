package com.micropos.products.service;

import com.micropos.products.model.Product;
import com.micropos.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> products() {
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(()-> productRepository.allProducts(),throwable -> getDefaultProducts());
    }

    private List<Product> getDefaultProducts(){
        List<Product> list = new ArrayList<>();
        try{      
            Product p = new Product("13284888", "Java从入门到精通（第6版）（软件开发视频大讲堂） Java入门经典 Java从入门到精通（第6版）（软件开发视频大讲堂） Java入门经典", 75.8, "https://img13.360buyimg.com/n1/s200x200_jfs/t1/186038/9/7947/120952/60bdd993E41eea7e2/48ab930455d7381b.jpg");
            list.add(p);
            return list;
        } catch (Exception e){}
        return list;
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findProduct(id);
    }

    @Override
    public Product randomProduct() {
        return null;
    }
}
