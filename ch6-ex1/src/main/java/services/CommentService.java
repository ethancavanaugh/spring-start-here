package services;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private static final Logger LOGGER = Logger.getLogger(CommentService.class.getName());

    public void publishComment(Comment comment) {
        LOGGER.info("Publishing comment: " + comment.getText());
    }
}
