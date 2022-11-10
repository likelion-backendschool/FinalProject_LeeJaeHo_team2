package com.example.finalProject;

import com.example.finalProject.domain.member.MemberReader;
import com.example.finalProject.domain.mybook.MyBook;
import com.example.finalProject.domain.mybook.MyBookService;
import com.example.finalProject.domain.post.PostCommand;
import com.example.finalProject.domain.post.PostReader;
import com.example.finalProject.domain.post.PostService;
import com.example.finalProject.domain.product.ProductCommand;
import com.example.finalProject.domain.product.ProductReader;
import com.example.finalProject.domain.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    PostService postService;
    @Autowired
    ProductService productService;

    @Autowired
    MemberReader memberReader;

    @Autowired
    ProductReader productReader;
    @Autowired
    PostReader postReader;
    @Autowired
    MyBookService myBookService;

    @Test
    public void storePost(){
        var member=memberReader.getMember(3L);
        PostCommand postCommand=new PostCommand(member,"testSubject2","testContent2","testHtml2");
        var savePost=postService.registerPost(postCommand);
        assertThat(savePost.getAuthor().getId()).isEqualTo(member.getId());
    }

    @Test
    public void ProductStoreTest(){
        var member=memberReader.getMember(3L);
        var post=postReader.getPost(2L);
        ProductCommand productCommand=new ProductCommand(member,post,"상품명2");
        var saveProduct=productService.productStore(productCommand.toEntity());
    }

    @Test
    public void myBookSaveTest(){
        var member=memberReader.getMember(3L);
        var product=productReader.getProduct(2L);
        MyBook myBook=new MyBook(member,product);
        myBookService.myBookStore(myBook);
    }

}
