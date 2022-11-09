package com.example.finalProject.infrastructure.member;

import com.example.finalProject.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUsername(String username);
    Boolean existsByUsername(String username);
}
