package com.movieflix.Controller;

import com.movieflix.Entity.Movie;
import com.movieflix.Mapper.MovieMapper;
import com.movieflix.Request.MovieRequest;
import com.movieflix.Response.MovieResponse;
import com.movieflix.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAllMovies() {
        List<MovieResponse> movies = movieService.searchAllMovies()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieResponse> findByIdMovies(@PathVariable Long id) {
        return movieService.searchMovieById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<MovieResponse> saveMovies(@RequestBody MovieRequest movieRequest) {
        Movie newMovie = MovieMapper.toMovie(movieRequest);
        Movie savedMovie = movieService.saveMovie(newMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(savedMovie));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {

        if (movieService.searchMovieById(id).isPresent()) {
            movieService.deleteMovieById(id);
            ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
