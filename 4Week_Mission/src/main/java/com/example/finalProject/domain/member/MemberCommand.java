package com.example.finalProject.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Builder
@Getter
@ToString
public class MemberCommand {
    private final String userName;
    private final String password;
    private final String emil;
    public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .username(userName)
                .password(passwordEncoder.encode(password))
                .email(emil)
                .build();
    }
}
