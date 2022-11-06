package com.example.finalProject.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class MemberCommand {
    private final String userName;
    private final String password;
    private final String emil;
    public Member toEntity(){
        return Member.builder()
                .username(userName)
                .password(password)
                .email(emil)
                .build();
    }
}
