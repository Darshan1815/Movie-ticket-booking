package com.ticketbooking.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Show;
import com.ticketbooking.demo.repositories.ScreenRepository;
import com.ticketbooking.demo.repositories.ShowRepository;
import com.ticketbooking.demo.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {
	
	@Autowired
	ShowRepository showRepo;
	
	@Autowired
	ScreenRepository screenRepo;

	@Override
	public Show addShows(Show show, Integer screenId) {
		
		Show newShow=new Show();
		Screen screen= screenRepo.findById(screenId).get();
		
		newShow.setShowTime(show.getShowTime());
		
		newShow.setScreen(screen);
		
		Show savedShow= showRepo.save(newShow);
		
		screen.getShows().add(savedShow);
		
		screenRepo.save(screen);
		
		return savedShow;
	}

	@Override
	public List<Show> findShowByScreenNumber(Integer screenId) {

		Screen screen= screenRepo.findById(screenId).get();

		
		return showRepo.findByScreen(screen);
	}

	@Override
	public List<Show> findShowByTheaterAndMovie(String theaterName, String movieTitle) {
		
		 return showRepo.findByTheaterNameAndMovieTitle(theaterName, movieTitle);
		
		
	}

	

}
