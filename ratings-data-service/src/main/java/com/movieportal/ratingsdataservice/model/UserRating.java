package com.movieportal.ratingsdataservice.model;

import java.util.List;
import lombok.Data;

@Data
public class UserRating {
	
	private List<Rating> userRating;

}
