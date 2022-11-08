package com.example.finalProject.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{
    private final MemberStore memberStore;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public Member registerPartner(MemberCommand command) {
        var initMember=command.toEntity(passwordEncoder);
        Member member=memberStore.store(initMember);
        return member;
    }
}
