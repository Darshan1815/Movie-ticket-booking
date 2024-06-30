package com.ticketbooking.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.demo.entities.Movie;
import com.ticketbooking.demo.entities.Show;
import com.ticketbooking.demo.repositories.MoviesRepository;
import com.ticketbooking.demo.repositories.ShowRepository;
import com.ticketbooking.demo.service.MovieService;
import com.ticketbooking.demo.service.ShowService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MoviesRepository movieRepo;
	
	@Autowired
	ShowRepository showRepo;

	@Override
	public Movie addMovie(Movie movie, Integer showId) {
		
		
		
		Movie newMovie= new Movie();
		
		Show show= showRepo.findById(showId).get();
		
		newMovie.setDescription(movie.getDescription());
		newMovie.setDuration(movie.getDuration());
		newMovie.setGenre(movie.getGenre());
		newMovie.setImage(movie.getImage());
		newMovie.setTitle(movie.getTitle());
		newMovie.setLanguage(movie.getLanguage());
		newMovie.getShows().add(show);
		
		Movie savedMovie=  movieRepo.save(newMovie);
		
		show.setMovie(savedMovie);
		
		showRepo.save(show);
		
		return savedMovie;
	}

	@Override
	public List<Movie> findByTitle(String title) {
		
		
		
		return movieRepo.findByTitle(title);
	}
	
	
}
