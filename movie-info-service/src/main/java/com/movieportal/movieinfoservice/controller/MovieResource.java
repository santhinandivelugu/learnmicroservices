package com.movieportal.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieportal.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId,"Harry Potter", "magical movie");
	}

}

