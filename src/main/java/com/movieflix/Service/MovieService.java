package com.movieflix.Service;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import com.movieflix.Entity.Streaming;
import com.movieflix.Repository.MovieRepository;
import com.movieflix.Response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<Movie> searchAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> searchMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> searchMovieByCategory(Long categoryId) {
        return movieRepository.findByCategories_CategoryId(categoryId);
    }

    public Movie saveMovie(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category ->
                    categoryService.searchCategoryById(category.getCategoryId()).ifPresent(categoriesFound::add)
                );
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming ->
                    streamingService.searchStreamingById(streaming.getStreamingId()).ifPresent(streamingsFound::add)
                );
        return streamingsFound;
    }

    public Optional<Movie> update(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie =  movieRepository.findById(id);

        if (optionalMovie.isPresent()) {

            List<Category> categories = this.findCategories(updatedMovie.getCategories());
            List<Streaming> streamings = this.findStreamings(updatedMovie.getStreamings());

            Movie movie = optionalMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(movie.getDescription());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setRating(updatedMovie.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            movieRepository.save(movie);

            return Optional.of(movie);
        }
        return Optional.empty();
    }
}
