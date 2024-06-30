package com.ticketbooking.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketbooking.demo.entities.Screen;
import com.ticketbooking.demo.entities.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {

	
	public List<Show> findByScreen(Screen screen);
	
	
	@Query("SELECT s FROM Show s WHERE s.screen.theater.name = :theaterName AND s.movie.title = :movieTitle")
    List<Show> findByTheaterNameAndMovieTitle(@Param("theaterName") String theaterName, @Param("movieTitle") String movieTitle);
	
}
