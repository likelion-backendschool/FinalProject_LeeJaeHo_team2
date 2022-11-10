package com.example.finalProject.infrastructure.member;

import com.example.finalProject.common.exception.InvalidParamException;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.member.MemberStore;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;

    @Override
    public Member store(Member initMember) {
        if(StringUtils.isEmpty(initMember.getUsername()))throw new InvalidParamException("username is empty");
        if(StringUtils.isEmpty(initMember.getPassword()))throw new InvalidParamException("password is empty");
        if(StringUtils.isEmpty(initMember.getEmail()))throw new InvalidParamException("email is empty");
        if(StringUtils.isEmpty(initMember.getUserToken()))throw new InvalidParamException("userToken is empty");

        return memberRepository.save(initMember);
    }
}
