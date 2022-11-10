package com.example.finalProject.domain.mybook;

import com.example.finalProject.common.exception.EntityNotFoundException;
import com.example.finalProject.domain.member.MemberReader;
import com.example.finalProject.interfaces.product.MyBookDetailDto;
import com.example.finalProject.interfaces.product.MyBookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class MyBookService {
    private final MyBookRepository myBookRepository;
    private final MemberReader memberReader;
    public MyBook myBookStore(MyBook myBook){
        return myBookRepository.save(myBook);
    }

    public List<MyBookResponseDto> findList(Long userId) {
        System.out.println("마이북 찾기");
        var member=memberReader.getMember(userId);
        var bookLists=myBookRepository.findByOwner(member);
        List<MyBookResponseDto> myBookResponseDtos =new ArrayList<>();
        for(MyBook myBook : bookLists){
            myBookResponseDtos.add(new MyBookResponseDto(myBook));
        }
        return myBookResponseDtos;
    }

    public MyBookDetailDto getBookDetail(Long bookId){
        var bookLists=myBookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);
        var myBookToDto=new MyBookDetailDto(bookLists);
        myBookToDto.getProduct().getBookChapters().add(new MyBookDetailDto.BookChapter(bookLists.getProduct().getPost()));
        return myBookToDto;
    }
}
