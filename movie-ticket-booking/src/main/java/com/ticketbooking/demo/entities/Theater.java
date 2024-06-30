package com.ticketbooking.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Theater {

	
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String location;
	    
	    private String city;

	    @OneToMany
	    @JsonIgnore
	    private List<Screen> screens = new ArrayList<>();
	
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public List<Screen> getScreens() {
			return screens;
		}

		public void setScreens(List<Screen> screens) {
			this.screens = screens;
		}

		public Theater(String name, String location, String city, List<Screen> screens) {
			super();
			this.name = name;
			this.location = location;
			this.city = city;
			this.screens = screens;
		}

		public Theater() {
			
		}

		
	
	
}
