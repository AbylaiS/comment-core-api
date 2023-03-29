package kz.dar.university.commentcoreapi.controller;

import kz.dar.university.commentcoreapi.model.CommentRequest;
import kz.dar.university.commentcoreapi.model.CommentResponse;
import kz.dar.university.commentcoreapi.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {


    private final CommentService commentService;

    @PostMapping
    public CommentResponse createComment(@RequestBody CommentRequest commentRequest){
        return commentService.createComment(commentRequest);
    }


    @PutMapping
    public CommentResponse updateComment(@RequestParam String commentId , @RequestBody CommentRequest commentRequest){
        commentRequest.setComment(commentId);
        return commentService.updateComment(commentRequest);

    }

    @GetMapping
    public CommentResponse getCommentById(@RequestParam String commentId){
        return commentService.getCommentById(commentId);
    }

    @GetMapping("/all")
    public List<CommentResponse> getAllComments(){
        return commentService.getAllComments();
    }

    @DeleteMapping
    public void deleteCommentById(@RequestParam String commentId){
        commentService.deleteCommentByEntityId(commentId);
    }

}
