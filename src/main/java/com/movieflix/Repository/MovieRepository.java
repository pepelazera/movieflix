package com.movieflix.Repository;

import com.movieflix.Entity.Category;
import com.movieflix.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByCategories_CategoryId(Long category);

}
