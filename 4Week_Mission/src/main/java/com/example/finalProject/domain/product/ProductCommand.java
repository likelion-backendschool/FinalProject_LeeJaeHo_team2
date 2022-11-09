package com.example.finalProject.domain.product;

import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class ProductCommand {
    private Member member;
    private Post post;
    private String subject;

public Product toEntity(){
    return Product.builder()
            .subject(subject)
            .member(member)
            .post(post)
            .build();
 }
}
