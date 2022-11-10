package com.example.finalProject.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class APIUserDTO extends User {
    private Long memberId;

    private String username;
    private String password;

    public APIUserDTO(Long memberId,String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.memberId=memberId;
        this.username = username;
        this.password = password;
    }
}
