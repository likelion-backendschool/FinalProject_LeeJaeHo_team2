package com.example.finalProject.infrastructure.member;

import com.example.finalProject.common.exception.EntityNotFoundException;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;
    @Override
    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Member getMember(String username) {
        return memberRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
