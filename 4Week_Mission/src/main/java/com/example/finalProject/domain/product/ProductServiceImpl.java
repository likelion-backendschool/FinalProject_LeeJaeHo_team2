package com.example.finalProject.domain.product;

import com.example.finalProject.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final MemberReader memberReader;
    private final ProductStore productStore;
    private final ProductReader productReader;

    @Override
    public Product productStore(Product initProduct) {
        return productStore.Store(initProduct);
    }

    @Override
    public List<Product> MyProducts(Long id) {
        var member=memberReader.getMember(id);
        return productReader.findByListProduct(member);
    }
}
