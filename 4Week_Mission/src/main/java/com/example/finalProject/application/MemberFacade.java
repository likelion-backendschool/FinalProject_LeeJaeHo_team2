package com.example.finalProject.application;

import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.member.MemberCommand;
import com.example.finalProject.domain.member.MemberService;
import com.example.finalProject.domain.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final NotificationService notificationService;
    //Todo 도메인 레이어와 그외 다른 서비스를 합쳐서 하나의 서비스로 만든다
    public Member registerMember(MemberCommand command){
        var member=memberService.registerPartner(command);
        notificationService.sendEmail(member.getEmail(),
                member.getUsername()+"님 환영합니다.",
                "설명");
        return member;
    }
}