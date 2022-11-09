package com.example.finalProject.domain.member;

import com.example.finalProject.common.exception.InvalidParamException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{
    private final MemberStore memberStore;
    private final PasswordEncoder passwordEncoder;

    private final MemberReader memberReader;
    @Override
    @Transactional
    public Member registerPartner(MemberCommand command) {
        var initMember=command.toEntity(passwordEncoder);
        if(memberReader.existsByUsername(initMember.getUsername())) throw new InvalidParamException("유저 닉네임 중복입니다.");
        Member member=memberStore.store(initMember);
        return member;
    }
}
