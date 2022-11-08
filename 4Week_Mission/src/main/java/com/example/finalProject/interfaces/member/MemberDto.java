package com.example.finalProject.interfaces.member;

import com.example.finalProject.common.util.Util;
import com.example.finalProject.domain.member.Member;
import lombok.Getter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDto {
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
