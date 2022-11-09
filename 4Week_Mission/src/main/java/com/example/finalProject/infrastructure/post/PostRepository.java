package com.example.finalProject.infrastructure.post;

import com.example.finalProject.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
