package com.boot_camp2.controller;

import java.util.List;

import com.boot_camp2.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot_camp2.Dao.MovieResponse;
import com.boot_camp2.service.MovieService;

@RestController
@RequestMapping("/movie/api")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/getsong/{id}")
    public ResponseEntity<MovieResponse> getmovieDetails(@PathVariable("id") int id) {
        MovieResponse movie = movieService.findSongDetailsBySongId(id);
        return new ResponseEntity<MovieResponse>(movie, HttpStatus.OK);
    }

    @GetMapping("/getDirHero/{id}")
    public ResponseEntity<MovieResponse> getDetails(@PathVariable("id") int id) {
        MovieResponse movieResponse = movieService.getMovieDetails(id);
        return new ResponseEntity<MovieResponse>(movieResponse, HttpStatus.OK);

    }

    @GetMapping("allmovies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        List<MovieResponse> movieResponse = movieService.findAllMovies();
        return new ResponseEntity<List<MovieResponse>>(movieResponse, HttpStatus.OK);
    }


    @PostMapping("/savemovie")
    public ResponseEntity<MovieResponse> saveMovie(Movie movie) {
        MovieResponse movieResponse = movieService.saveMovie(movie);
        return new ResponseEntity<MovieResponse>(movieResponse, HttpStatus.CREATED);
    }
}
