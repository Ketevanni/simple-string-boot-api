package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.FilmInfo;
import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.entities.Film;
import ge.ibsu.demo.entities.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT NEW ge.ibsu.demo.dto.FilmInfo(f.title, f.description, f.rating) " +
            "FROM Film f " +
            "WHERE f.title = :title AND f.description = :description " +
            "AND f.release_year = :release_year AND f.language = :language")
    Page<FilmInfo>searchFilm(@Param("title") String title,
                             @Param("description") String description,
                             @Param("release_year") Integer release_year,
                             @Param("language") Language language,
                             Pageable pageable);

}