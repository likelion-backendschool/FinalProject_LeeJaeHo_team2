package com.example.finalProject.domain.member;

public interface MemberReader {
    Member getMember(Long MemberId);

    Member getMember(String username);

    Boolean existsByUsername(String username);

}
