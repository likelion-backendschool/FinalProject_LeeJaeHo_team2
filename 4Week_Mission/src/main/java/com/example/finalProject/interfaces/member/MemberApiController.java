package com.example.finalProject.interfaces.member;

import com.example.finalProject.common.response.CommonResponse;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.infrastructure.member.MemberRepository;
import com.example.finalProject.security.APIUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApiController {
    private  final MemberRepository memberRepository;
    @GetMapping("/me")
    public CommonResponse getMemberInfo(@AuthenticationPrincipal APIUserDTO apiUserDTO){
        System.out.println("유저 정보 나갑니다!!!");
        var user=memberRepository.findByUsername(apiUserDTO.getUsername()).orElseThrow();
        return CommonResponse.success(Map.of("member",new MemberDto.MemberResponse(user)),"성공");
    }
}
