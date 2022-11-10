package com.example.finalProject;

import com.example.finalProject.domain.member.Member;
import com.example.finalProject.infrastructure.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert(){
        Member member= Member.builder()
                .username("jaeho")
                .password(passwordEncoder.encode("1234"))
                .email("asd@naver.com")
                .build();
        memberRepository.save(member);
    }
}
