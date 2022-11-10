package com.example.finalProject.domain.post;

import com.example.finalProject.common.util.TokenGenerator;
import com.example.finalProject.domain.AbstractEntity;
import com.example.finalProject.domain.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private String content;

    private String contentHtml;
    @ManyToOne(fetch = LAZY)
    @JsonIgnore
    private Member author;

    @Builder
    public Post(Member member,String subject,String content,String contentHtml){
        if(!StringUtils.hasText(subject)) throw new RuntimeException("empty subject ");
        if(!StringUtils.hasText(content)) throw new RuntimeException("empty content ");
        if(!StringUtils.hasText(contentHtml)) throw new RuntimeException("empty contentHtml ");
        this.author=member;
        this.subject=subject;
        this.content=content;
        this.contentHtml=contentHtml;
    }
}
