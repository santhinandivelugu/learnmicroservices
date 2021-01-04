package com.movieportal.movieinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
	
	private String movieId;
	private String name;
	private String desc;

}
