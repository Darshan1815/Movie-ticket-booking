package com.ticketbooking.demo.entities;

import com.ticketbooking.demo.domain.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
 
     private String city;
     
     private String email;
     
     
     private String password;

   private UserRole userRole;
	
   
 
     public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Admin(String city, String email, String password, UserRole userRole) {
		super();
		this.city = city;
		this.email = email;
		this.password = password;
		this.userRole = userRole;
	}

	
	public Admin() {
		
	}
	
	
	

	

}
