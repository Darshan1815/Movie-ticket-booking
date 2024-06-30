package com.ticketbooking.demo.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Show {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JsonIgnore
	    private Screen screen;

	    @ManyToOne
	    @JsonIgnore
	    private Movie movie;

	    private LocalDateTime showTime;
	    
	    
	    

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Screen getScreen() {
			return screen;
		}

		public void setScreen(Screen screen) {
			this.screen = screen;
		}

		public Movie getMovie() {
			return movie;
		}

		public void setMovie(Movie movie) {
			this.movie = movie;
		}

		public LocalDateTime getShowTime() {
			return showTime;
		}

		public void setShowTime(LocalDateTime showTime) {
			this.showTime = showTime;
		}

		public Show(Screen screen, Movie movie, LocalDateTime showTime) {
			super();
			this.screen = screen;
			this.movie = movie;
			this.showTime = showTime;
		}

		public Show() {
			
		}
	
	    
	    

}
