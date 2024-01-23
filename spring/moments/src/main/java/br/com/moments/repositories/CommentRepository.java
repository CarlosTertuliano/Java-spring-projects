package br.com.moments.repositories;

import br.com.moments.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM Comment c WHERE c.idMoment = %?1%", nativeQuery = true)
    List<Comment> findAllByMoment(long idMoment);
}
