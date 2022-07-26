package com.example.springdataredis.repositories;

import com.example.springdataredis.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RequiredArgsConstructor
public class ProductDao {

    private RedisTemplate redisTemplate;

    private static final String HASH_KEY = "Product";

    public Product save(Product product){
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Product getProductById(Long id){
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public void deleteProduct(Long id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
}
