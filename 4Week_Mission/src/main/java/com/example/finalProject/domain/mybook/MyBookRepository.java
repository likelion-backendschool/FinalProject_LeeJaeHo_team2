package com.example.finalProject.domain.mybook;

import com.example.finalProject.domain.member.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyBookRepository extends JpaRepository<MyBook,Long> {
    @EntityGraph(attributePaths = {"product","owner"})
    List<MyBook> findByOwner(Member member);
}
