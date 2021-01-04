package com.movieportal.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieportal.ratingsdataservice.model.Rating;
import com.movieportal.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {
	
	@GetMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable String userId) {
		
		List<Rating> ratings = Arrays.asList(new Rating("123", 4),
											 new Rating("456", 5));
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
