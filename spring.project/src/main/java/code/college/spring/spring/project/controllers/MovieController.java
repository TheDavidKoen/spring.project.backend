package code.college.spring.spring.project.controllers;

import code.college.spring.spring.project.models.Movie;
import code.college.spring.spring.project.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Movies' APIs", description = "Here are all the controllers for the movies' data.")
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @Operation(
            summary = "Retrieves all movies.",
            description = "Sends a GET request that lists all the movies.",
            tags = { "Movies", "Get Requests" })
    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieves an individual movie.",
            description = "Sends a GET request that lists a single movie.",
            tags = { "Movies", "Get Requests" })
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
}