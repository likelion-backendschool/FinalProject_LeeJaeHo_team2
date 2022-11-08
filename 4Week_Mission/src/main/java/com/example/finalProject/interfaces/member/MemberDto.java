package com.example.finalProject.interfaces.member;

import com.example.finalProject.common.util.Util;
import com.example.finalProject.domain.member.Member;
import com.example.finalProject.domain.member.MemberCommand;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    @RequiredArgsConstructor
    public static class RegisterRequest {
        private final PasswordEncoder passwordEncoder;
        @NotEmpty(message = "partnerName 는 필수값입니다")
        private String memberName;

        @NotEmpty(message = "password 는 필수값입니다")
        private String password;

        @Email(message = "email 형식에 맞아야 합니다")
        @NotEmpty(message = "email 는 필수값입니다")
        private String email;

        public MemberCommand toCommand() {
            return MemberCommand.builder()
                    .userName(memberName)
                    .password(passwordEncoder.encode(password))
                    .emil(email)
                    .build();
        }
    }
    @Getter
    @ToString
    public static class MemberResponse{
        private final Long id;
        private final List<Integer> createDate;
        private final List<Integer> modifyDate;
        private final String username;
        private final String email;
        private final boolean emailVerified;
        private final String nickname;

        public MemberResponse(Member member) {
            this.id = member.getId();
            this.createDate= Util.zoneDateToList(member.getCreateDate());
            this.modifyDate = Util.zoneDateToList(member.getModifyDate());
            this.username = member.getUsername();
            this.email = member.getEmail();
            this.emailVerified = member.isEmailVerified();
            this.nickname = member.getNickname();
        }
    }

}
