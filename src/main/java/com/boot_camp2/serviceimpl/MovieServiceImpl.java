package com.boot_camp2.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot_camp2.Dao.MovieResponse;
import com.boot_camp2.entity.Movie;
import com.boot_camp2.repository.MovieRepo;
import com.boot_camp2.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	ModelMapper modelMapper;

	public MovieResponse findSongDetailsBySongId(int id) {
		Movie movieDetails = movieRepo.getSongDetailsBasedOnSongId(id);
		MovieResponse movieResponse=modelMapper.map(movieDetails, MovieResponse.class);
		return movieResponse;
	}

	@Override
	public MovieResponse getMovieDetails(int id) {
		Movie movie=movieRepo.getMovieDetails(id);
		MovieResponse response=modelMapper.map(movie, MovieResponse.class);
		return response;
	}

	@Override
	public List<MovieResponse> findAllMovies() {
		List<Movie> movies=movieRepo.findAll();
	List<MovieResponse> movieResponse = Arrays.asList(modelMapper.map(movies, MovieResponse[].class));
		return movieResponse;
	}

}
