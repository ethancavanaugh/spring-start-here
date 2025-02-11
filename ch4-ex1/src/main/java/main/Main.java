package main;

import model.Comment;
import proxies.EmailCommentNotificationProxy;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args){
        var commentService = new CommentService(new DBCommentRepository(), new EmailCommentNotificationProxy());

        Comment comment = new Comment("Ethan", "Hi, this is a comment.");
        commentService.publishComment(comment);
    }
}
