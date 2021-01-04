package com.movieportal.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieportal.moviecatalogservice.model.CatalogItem;
import com.movieportal.moviecatalogservice.model.Movie;
//import com.movieportal.moviecatalogservice.model.Rating;
import com.movieportal.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalogs")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {

		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, UserRating.class);
		
		return ratings.getUserRating().stream().map(rating -> {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
		})
		.collect(Collectors.toList());
		
		// for each movie id call movie info service and get details
		
		//put them all together
		

		
	}
}

/* 
returning hard coded values
return Collections.singletonList(new CatalogItem("Harry Potter", "Magical", 4)); 
*/
