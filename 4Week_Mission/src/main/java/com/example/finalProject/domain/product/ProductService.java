package com.example.finalProject.domain.product;

import java.util.List;

public interface ProductService {
    Product productStore(Product initProduct);

    List<Product> MyProducts(Long id);
}
