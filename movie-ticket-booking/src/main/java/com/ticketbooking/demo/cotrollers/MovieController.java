package com.ticketbooking.demo.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.demo.entities.Movie;
import com.ticketbooking.demo.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	
	@PostMapping("api/addmovie/show/{showId}")
	public Movie addMovie(@RequestBody Movie movie, @PathVariable Integer showId) {
		
		
		Movie savedMovie= movieService.addMovie(movie, showId);
		
		return savedMovie;
	}

	
	@GetMapping("api/searchmovie/title/{title}")
	public List<Movie> searchMovie( @PathVariable String title) {
		
		
		return movieService.findByTitle(title);
	}
	
	

}
