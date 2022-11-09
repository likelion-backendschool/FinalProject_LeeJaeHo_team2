package com.example.finalProject.infrastructure.post;

import com.example.finalProject.common.exception.EntityNotFoundException;
import com.example.finalProject.domain.post.Post;
import com.example.finalProject.domain.post.PostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReaderImpl implements PostReader {
    private final PostRepository postRepository;
    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
