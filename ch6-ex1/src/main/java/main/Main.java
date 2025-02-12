package main;

import config.AppConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var cs = context.getBean(CommentService.class);

        Comment comment = new Comment("Test comment", "Ethan");
        cs.publishComment(comment);
    }
}
