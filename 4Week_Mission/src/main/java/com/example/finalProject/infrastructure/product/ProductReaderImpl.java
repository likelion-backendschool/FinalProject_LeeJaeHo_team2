package com.example.finalProject.infrastructure.product;

import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.product.Product;
import com.example.finalProject.domain.product.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {
    private final ProductRepository productRepository;
    @Override
    public List<Product> findByListProduct(Member member) {
        return productRepository.findByAuthor(member);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(EntityExistsException::new);
    }
}
