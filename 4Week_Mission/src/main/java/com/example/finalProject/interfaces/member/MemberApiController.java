package com.example.finalProject.interfaces.member;

import com.example.finalProject.application.MemberFacade;
import com.example.finalProject.common.response.CommonResponse;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.member.MemberReader;
import com.example.finalProject.infrastructure.member.MemberRepository;
import com.example.finalProject.security.APIUserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberApiController {
    private  final MemberReader memberReader;
    private  final MemberFacade memberFacade;
    @GetMapping("/me")
    public ResponseEntity<CommonResponse> getMemberInfo(@AuthenticationPrincipal APIUserDTO apiUserDTO){
        System.out.println("유저 정보 나갑니다!!!");
        var user=memberReader.getMember(apiUserDTO.getMemberId());
        return new ResponseEntity<>(CommonResponse.success(Map.of("member",new MemberDto.MemberResponse(user)),"성공"), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> registerMember(@Valid MemberDto.RegisterRequest request){
        log.info("진입");
        var command=request.toCommand();
        var memberInfo=memberFacade.registerMember(command);
        var response=new MemberDto.MemberResponse(memberInfo);
        return new ResponseEntity<>(CommonResponse.success(response,"성공"),HttpStatus.OK);
    }

}
