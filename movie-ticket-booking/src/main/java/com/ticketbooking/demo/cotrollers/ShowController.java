package com.ticketbooking.demo.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Show;
import com.ticketbooking.demo.service.ShowService;

@RestController
public class ShowController {
	
	@Autowired
	ShowService showService;
	
	
	
	@PostMapping("api/addshow/screen/{screenId}")
	public Show addShow(@RequestBody Show show, @PathVariable Integer screenId) {
		
		Show savedShow= showService.addShows(show, screenId);
		
		
		return savedShow;
	}
	
	
	@GetMapping("api/getshow/screen/{screenId}")
	public List <Show> getShows( @PathVariable Integer screenId) {
		
		List<Show> savedShow= showService.findShowByScreenNumber(screenId);
		
		
		return savedShow;
	}
	
	
	
	 @GetMapping("api/search/shows")
	    public List<Show> searchShows(@RequestParam String theaterName, @RequestParam String movieTitle) {
	        return showService.findShowByTheaterAndMovie(theaterName, movieTitle);
	    }
	
	
	

}
