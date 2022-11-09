package com.example.finalProject.infrastructure.product;

import com.example.finalProject.domain.product.Product;
import com.example.finalProject.domain.product.ProductStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStoreImpl implements ProductStore {
    private final ProductRepository productRepository;
    @Override
    public Product Store(Product initProduct) {
        return productRepository.save(initProduct);
    }
}
