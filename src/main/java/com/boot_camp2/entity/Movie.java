package com.boot_camp2.entity;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String movieName;
	private String hero;
	private String director;

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getMovieName() {

		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getHero() {

		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Movie(int id, String movieName, String hero, String director) {
		this.id = id;
		this.movieName = movieName;
		this.hero = hero;
		this.director = director;
	}

    public Movie() {
    }
}
