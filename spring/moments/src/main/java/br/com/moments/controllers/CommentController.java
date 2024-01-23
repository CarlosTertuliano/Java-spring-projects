package br.com.moments.controllers;

import br.com.moments.models.Comment;
import br.com.moments.models.CommentDTO;
import br.com.moments.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody CommentDTO commentDTO){
        this.commentService.saveComment(commentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/comments/{idMoment}")
    public ResponseEntity<List<Comment>> getAllComments(@PathVariable long idMoment){
        List<Comment> comments = this.commentService.getAllCommentsByMoment(idMoment);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
