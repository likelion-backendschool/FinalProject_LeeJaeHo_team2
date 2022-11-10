package com.example.finalProject.interfaces.product;

import com.example.finalProject.common.util.Util;
import com.example.finalProject.domain.mybook.MyBook;
import com.example.finalProject.domain.post.Post;
import lombok.Getter;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyBookDetailDto {
    private final Long id;
    private final List<Integer> createDate;
    private final List<Integer> modifyDate;
    private final Long ownerId;
    private final Product product;
    public MyBookDetailDto(MyBook myBook){
        this.id=myBook.getId();
        this.createDate= Util.zoneDateToList(myBook.getCreateDate());
        this.modifyDate=Util.zoneDateToList(myBook.getModifyDate());
        this.ownerId=myBook.getOwner().getId();
        this.product= new Product(myBook.getProduct());
    }
    @Getter
    public static class Product{
        public  Long id;
        public List<Integer> createDate;
        public List<Integer> modifyDate;
        public Long authorId;
        public String authorName;
        public String subject;
        public List<BookChapter> bookChapters=new ArrayList<>();

        public Product(com.example.finalProject.domain.product.Product product) {
            this.id = product.getId();
            this.createDate = Util.zoneDateToList(product.getCreateDate());
            this.modifyDate = Util.zoneDateToList(product.getModifyDate());
            this.authorId = product.getAuthor().getId();
            this.authorName = product.getAuthor().getNickname();
            this.subject = product.getSubject();
        }
    }

    @Getter
    public static class BookChapter{
        private Long id;
        private String subject;
        private String content;
        private String contentHtml;
        public BookChapter(Post post){
            this.id=post.getId();
            this.subject= post.getSubject();
            this.content= post.getContent();
            this.contentHtml= post.getContentHtml();
        }
    }
}
