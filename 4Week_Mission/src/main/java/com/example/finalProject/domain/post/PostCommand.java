package com.example.finalProject.domain.post;

import com.example.finalProject.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class PostCommand {
    private Member member;
    private String subject;
    private String content;
    private String contentHtml;

public Post toEntity(){
    return Post.builder()
            .subject(subject)
            .content(content)
            .contentHtml(contentHtml)
            .member(member)
            .build();
}
}
