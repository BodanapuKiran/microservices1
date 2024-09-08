package com.boot_camp2.repository;

import com.boot_camp2.entity.Movie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MovieRepoTest {
    @Autowired
    private MovieRepo movieRepo;
    Movie movie;

    @BeforeEach
    void setUp() {
        movie=new Movie(1,"KGF","yash","prashanthNeel");
        movieRepo.save(movie);

    }

    @AfterEach
    void tearDown() {
        movie=null;
        movieRepo.deleteAll();
    }

    @Test
    void testFindByMovieName(){
        List<Movie> movieList =movieRepo.findByMovieName("KGF");
        assertThat(movieList.get(0).getId()).isEqualTo(movie.getId());
    }

    @Test
    void testFindByMovieName_Failure(){
        List<Movie> movieList=movieRepo.findByMovieName("Maharshi");
        assertThat(movieList.isEmpty()).isTrue();
    }
}
