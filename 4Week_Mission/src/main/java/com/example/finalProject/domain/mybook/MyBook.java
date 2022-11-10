package com.example.finalProject.domain.mybook;

import com.example.finalProject.domain.AbstractEntity;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyBook extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    private Product product;

    @ManyToOne(fetch = LAZY)
    private Member owner;
    @Builder
    public MyBook(Member member,Product product){
        this.product=product;
        this.owner=member;
    }
}
