package com.example.finalProject.infrastructure.post;

import com.example.finalProject.common.exception.EntityNotFoundException;
import com.example.finalProject.common.exception.InvalidParamException;
import com.example.finalProject.domain.post.Post;
import com.example.finalProject.domain.post.PostStore;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostStoreImpl implements PostStore{
    private final PostRepository postRepository;
    @Override
    public Post store(Post intiPost) {
        if(intiPost.getAuthor()==null) throw new InvalidParamException("member is empty");
        if(StringUtils.isEmpty(intiPost.getContent())) throw new InvalidParamException("content is empty");
        if(StringUtils.isEmpty(intiPost.getSubject())) throw new InvalidParamException("subject is empty");
        if(StringUtils.isEmpty(intiPost.getContentHtml())) throw new InvalidParamException("contentHtml is empty");
        return postRepository.save(intiPost);
    }
}
