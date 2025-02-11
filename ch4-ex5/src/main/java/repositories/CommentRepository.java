package repositories;

import model.Comment;
import org.springframework.stereotype.Component;

@Component
public interface CommentRepository {
    public void storeComment(Comment comment);
}
