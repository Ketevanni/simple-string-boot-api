package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT f FROM Film f " +
            "WHERE (:title is null or f.title LIKE %:title%) " +
            "AND (:description is null or f.description LIKE %:description%) " +
            "AND (:releaseYear is null or f.releaseYear = :releaseYear) " +
            "AND (:language is null or f.language = :language) ")
    Page<Film> search(String title, String description, Integer releaseYear, Pageable pageable);


}