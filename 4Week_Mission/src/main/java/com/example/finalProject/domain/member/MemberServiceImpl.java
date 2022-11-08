package com.example.finalProject.domain.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements  MemberService{
    private final MemberStore memberStore;
    @Override
    @Transactional
    public Member registerPartner(MemberCommand command) {
        var initMember=command.toEntity();
        Member member=memberStore.store(initMember);
        return member;
    }
}
