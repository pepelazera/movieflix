package com.movieflix.Controller;

import com.movieflix.Entity.Movie;
import com.movieflix.Mapper.MovieMapper;
import com.movieflix.Request.MovieRequest;
import com.movieflix.Response.MovieResponse;
import com.movieflix.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

}
