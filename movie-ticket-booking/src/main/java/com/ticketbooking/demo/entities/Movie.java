package com.ticketbooking.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Movie {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    private String genre;

	    private String duration; 

	    private String description;
	    
	    private String image;
	    
	    private String language;

	    public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		@OneToMany
		@JsonIgnore
	    private List<Show> shows=new ArrayList<>();
	    
	    
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}

		

		
		public Movie(String title, String genre, String duration, String description, String image, String language,
				List<Show> shows) {
			super();
			this.title = title;
			this.genre = genre;
			this.duration = duration;
			this.description = description;
			this.image = image;
			this.language = language;
			this.shows = shows;
		}

		public Movie() {
			
		}

	    
	    
	
	
	
}
