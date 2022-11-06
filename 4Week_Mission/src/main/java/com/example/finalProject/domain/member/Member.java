package com.example.finalProject.domain.member;

import com.example.finalProject.common.util.TokenGenerator;
import com.example.finalProject.domain.AbstractEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Getter
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AbstractEntity {
    private static final String PREFIX_USER="user_";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private boolean emailVerified;

    private String nickname;

    private String userToken;

    @Builder
    public Member(String username,String password,String email){
        if(!StringUtils.hasText(username)) throw new RuntimeException("empty username ");
        if(!StringUtils.hasText(password)) throw new RuntimeException("empty password ");
        if(!StringUtils.hasText(email)) throw new RuntimeException("empty email ");
        this.username=username;
        this.password=password;
        this.email=email;
        this.emailVerified=false;
        this.userToken= TokenGenerator.randomCharacterWithPrefix(PREFIX_USER);
    }

}
