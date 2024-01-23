package br.com.moments.repositories;

import br.com.moments.models.Moment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MomentRepository extends JpaRepository<Moment, Long> {

    @Query(value = "SELECT * FROM Moment m WHERE m.title LIKE %?1%", nativeQuery = true)
    Moment findByTitle(String title);
}
