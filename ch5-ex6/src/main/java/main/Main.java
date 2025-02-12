package main;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var cs = context.getBean(CommentService.class);
        var us = context.getBean(UserService.class);

        System.out.println(cs.getCommentRepository() == us.getCommentRepository());
    }
}
