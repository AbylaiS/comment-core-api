package kz.dar.university.commentcoreapi.service;

import kz.dar.university.commentcoreapi.model.CommentRequest;
import kz.dar.university.commentcoreapi.model.CommentResponse;
import kz.dar.university.commentcoreapi.repository.CommentEntity;
import kz.dar.university.commentcoreapi.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService implements ICommentService {


    private final CommentRepository commentRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public CommentResponse createComment(CommentRequest commentRequest) {
        commentRequest.setComment(UUID.randomUUID().toString());
        CommentEntity commentEntity = modelMapper.map(commentRequest , CommentEntity.class);
        commentRepository.save(commentEntity);
        return modelMapper.map(commentEntity , CommentResponse.class);
    }

    @Override
    public CommentResponse updateComment(CommentRequest commentRequest) {
        CommentEntity commentEntity = modelMapper.map(commentRequest , CommentEntity.class);
        CommentEntity dbEntity = commentRepository.getCommentEntityByCommentId(commentRequest.getComment());

        commentEntity.setId(dbEntity.getId());
        commentRepository.save(commentEntity);

        return modelMapper.map(commentEntity , CommentResponse.class);
    }

    @Override
    public CommentResponse getCommentById(String commentId) {
        CommentEntity commentEntity = commentRepository.getCommentEntityByCommentId(commentId);

        return modelMapper.map(commentEntity , CommentResponse.class);

    }

    @Override
    public List<CommentResponse> getAllComments() {

        return commentRepository.getCommentEntityBy().
                stream().map(comment -> modelMapper.map(comment ,
                CommentResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CommentEntity deleteCommentByEntityId(String commentId) {
       return commentRepository.getCommentEntityByCommentId(commentId);
    }
}
