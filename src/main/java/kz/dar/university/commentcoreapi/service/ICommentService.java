package kz.dar.university.commentcoreapi.service;

import kz.dar.university.commentcoreapi.model.CommentRequest;
import kz.dar.university.commentcoreapi.model.CommentResponse;
import kz.dar.university.commentcoreapi.repository.CommentEntity;

import java.util.List;


public interface ICommentService {

    CommentResponse createComment(CommentRequest commentRequest);

    CommentResponse updateComment(CommentRequest commentRequest);

    CommentResponse getCommentById(String commentId);

    List<CommentResponse> getAllComments();

    CommentEntity deleteCommentByEntityId(String commentId);

}
