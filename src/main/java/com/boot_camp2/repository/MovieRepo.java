package com.boot_camp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot_camp2.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

	@Query(nativeQuery = true, value = "SELECT m.id,m.director,m.hero,m.movie_name FROM springboot.movie m join springboot.song s on s.id=m.song_id where m.song_id=:song_id")
	public Movie getSongDetailsBasedOnSongId(@Param("song_id") int id);


	@Query(nativeQuery = true, value = "select m.id,m.director,m.hero,m.movie_name from springboot.movie m join  springboot.song s on s.id=m.song_id where m.song_id=:song_id")
	public Movie getMovieDetails(@Param("song_id") int id);


	public List<Movie> findByMovieName(String movieName);


}
