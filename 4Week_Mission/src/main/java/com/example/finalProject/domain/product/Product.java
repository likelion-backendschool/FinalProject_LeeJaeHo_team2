package com.example.finalProject.domain.product;

import com.example.finalProject.domain.AbstractEntity;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    private Member author;
    @OneToOne
    private Post post;
    private String subject;

    @Builder
    public Product(Member member,Post post,String subject){
       this.author=member;
       this.post=post;
       this.subject=subject;
    }
}
