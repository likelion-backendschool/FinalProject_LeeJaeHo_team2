package com.example.finalProject.domain.product;

import com.example.finalProject.domain.member.Member;

import java.util.List;

public interface ProductReader{
    List<Product> findByListProduct(Member member);

    Product getProduct(Long id);
}
