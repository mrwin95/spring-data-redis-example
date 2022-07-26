package com.example.springdataredis.controller;

import com.example.springdataredis.entity.Product;
import com.example.springdataredis.repositories.ProductDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private ProductDao productDao;

    @PostMapping("")
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }
}
