package com.boot_camp2.service;

import java.util.List;

import com.boot_camp2.Dao.MovieResponse;
import com.boot_camp2.entity.Movie;

public interface MovieService {
	public MovieResponse findSongDetailsBySongId(int id);
	
	
	public MovieResponse getMovieDetails(int id);
	
	public List<MovieResponse> findAllMovies();

	public  MovieResponse addMovie(Movie movie);

	public Movie findById(int id);
}
