package repositories;

import model.Comment;

public interface CommentRepository {
    public void storeComment(Comment comment);
}
