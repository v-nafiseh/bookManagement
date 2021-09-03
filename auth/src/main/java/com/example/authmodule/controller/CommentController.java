package com.example.authmodule.controller;

import com.example.authmodule.model.Comment;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@NoArgsConstructor
public class CommentController {

    ArrayList<Comment> allComments = new ArrayList<>();
    ArrayList<Comment> comments = new ArrayList<>();
    private Long bookID;



    @PostMapping(value = "/get_book/{bookID}/add_cm")
    public Comment addcm(@RequestBody String content,@RequestParam long bookID){
        //enter cm : first your name,the content of comment
        String[] input = content.split(",");
        Comment comment = new Comment(input[0],input[1],this.bookID);
        allComments.add(comment);
        return comment;
    }

    @GetMapping(value = "/get_book/{bookId}/getAllCm")
    public ArrayList<Comment> getcm(@RequestParam long bookId){
        for(Comment comment: allComments){
            if (comment.getBid()==bookId)
                comments.add(comment);
        }
        return comments;
    }

    public void setBookName(Long id) {
        this.bookID = id;
    }

}
