package com.example.finalProject.interfaces.product;

import com.example.finalProject.common.response.CommonResponse;
import com.example.finalProject.domain.mybook.MyBook;
import com.example.finalProject.domain.mybook.MyBookService;
import com.example.finalProject.security.APIUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/myBooks")
@RequiredArgsConstructor
public class ProductApiController {
    private final MyBookService myBookService;

    @GetMapping
    public CommonResponse findByMyProduct(@AuthenticationPrincipal APIUserDTO apiUserDTO){
        var userId=apiUserDTO.getMemberId();
        var listMyBook=myBookService.findList(userId);
        return CommonResponse.success(Map.of("myBooks", listMyBook),"성공");
    }

    @GetMapping("/{myBookId}")
    public CommonResponse findDetailMyBook(@PathVariable(name= "myBookId")Long bookId,@AuthenticationPrincipal APIUserDTO apiUserDTO){
        var userId=apiUserDTO.getMemberId();
        var detailBook=myBookService.getBookDetail(bookId);
        return CommonResponse.success(Map.of("myBook",detailBook),"성공");
    }

}
