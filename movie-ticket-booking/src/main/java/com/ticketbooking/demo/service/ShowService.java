package com.ticketbooking.demo.service;

import java.util.List;

import com.ticketbooking.demo.entities.Show;

public interface ShowService {

	
	public Show addShows(Show show, Integer screenId);
	
	public List<Show> findShowByScreenNumber(Integer screenId);
	
	public List<Show> findShowByTheaterAndMovie(String theaterName, String movieTitle );
	
}
