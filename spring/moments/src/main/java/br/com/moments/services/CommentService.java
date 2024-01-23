package br.com.moments.services;

import br.com.moments.models.Comment;
import br.com.moments.models.CommentDTO;
import br.com.moments.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(CommentDTO commentDTO){
        Comment comment = new Comment(commentDTO.getUserName(), commentDTO.getTextComent(),
                commentDTO.getIdMoment(), LocalDate.now());
        this.commentRepository.save(comment);
    }

    public List<Comment> getAllCommentsByMoment(long idMoment) {
        return this.commentRepository.findAllByMoment(idMoment);
    }
}
