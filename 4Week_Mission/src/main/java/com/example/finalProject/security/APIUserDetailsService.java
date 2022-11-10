package com.example.finalProject.security;

import com.example.finalProject.domain.member.Member;
import com.example.finalProject.infrastructure.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class APIUserDetailsService implements UserDetailsService {

    //주입
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member result = memberRepository.findByUsername(username).orElseThrow(() ->new UsernameNotFoundException("Cannot find mid"));
        log.info("APIUserDetailsService apiUser-------------------------------------");
        APIUserDTO dto =  new APIUserDTO(
                result.getId(),
                result.getUsername(),
                result.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        log.info(dto);

        return dto;
    }
}
