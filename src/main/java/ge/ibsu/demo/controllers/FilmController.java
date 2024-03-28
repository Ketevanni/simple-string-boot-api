package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.entities.Film;
import ge.ibsu.demo.services.FilmService;
import ge.ibsu.demo.util.GeneralUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public ResponseEntity<Page<Film>> searchFilms(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer releaseYear,
            Pageable pageable) {

        Page<Film> films = filmService.searchFilms(title, description, releaseYear, pageable);
        return ResponseEntity.ok(films);
    }

}
