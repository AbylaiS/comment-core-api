package kz.dar.university.commentcoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity , Long> {

    List<CommentEntity> getCommentEntityByComment(String comment);

    CommentEntity getCommentEntityByCommentId(String commentId);

    List<CommentEntity> getCommentEntityBy();

    CommentEntity deleteCommentEntityByCommentId(String commentId);



}
