package com.example.finalProject.interfaces.product;

import com.example.finalProject.common.util.Util;
import com.example.finalProject.domain.mybook.MyBook;
import lombok.Getter;

import java.util.List;
@Getter
public class MyBookResponseDto {
    private Long id;
    private List<Integer> createDate;
    private  List<Integer> modifyDate;
    private  Long ownerId;
    private Product product;
    public MyBookResponseDto(MyBook myBook){
        this.id=myBook.getId();
        this.createDate=Util.zoneDateToList(myBook.getCreateDate());
        this.modifyDate=Util.zoneDateToList(myBook.getModifyDate());
        this.ownerId=myBook.getOwner().getId();
        this.product=new Product(myBook.getProduct());
    }
    @Getter
    public class Product{
        public  Long id;
        public List<Integer> createDate;
        public List<Integer> modifyDate;
        public Long authorId;
        public String authorName;
        public String subject;

        public  Product(com.example.finalProject.domain.product.Product product) {
            this.id = product.getId();
            this.createDate = Util.zoneDateToList(product.getCreateDate());
            this.modifyDate = Util.zoneDateToList(product.getModifyDate());
            this.authorId = product.getAuthor().getId();
            this.authorName = product.getAuthor().getNickname();
            this.subject = product.getSubject();
        }
    }
}

