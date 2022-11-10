package com.example.finalProject.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PostServiceImpl implements PostService{
    private final PostStore postStore;
    @Override
    public Post registerPost(PostCommand command) {
        var initPost=command.toEntity();
        Post post=postStore.store(initPost);
        return post;
    }
}
