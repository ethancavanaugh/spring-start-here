package main;

import config.AppConfig;
import model.Comment;
import services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var commentService = context.getBean(CommentService.class);

        Comment comment = new Comment("Ethan", "Hi, this is a comment.");
        commentService.publishComment(comment);
    }
}
