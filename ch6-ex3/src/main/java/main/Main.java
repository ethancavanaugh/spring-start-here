package main;

import config.AppConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var cs = context.getBean(CommentService.class);

        Comment comment = new Comment("Test comment", "Ethan");
        String res = cs.publishComment(comment);
        LOGGER.info(res);
    }
}
