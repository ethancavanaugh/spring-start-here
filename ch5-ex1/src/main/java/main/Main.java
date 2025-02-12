package main;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var cs1 = context.getBean(CommentService.class);
        var cs2 = context.getBean(CommentService.class);

        System.out.println(cs1 == cs2);
    }
}
