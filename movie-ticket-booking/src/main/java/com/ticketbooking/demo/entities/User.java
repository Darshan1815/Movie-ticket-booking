package com.ticketbooking.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticketbooking.demo.domain.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	
	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
 
   private String name;
 
 private String email;
 
 
private String password;
 
 private UserRole userRole;
 
 @OneToMany
 @JsonIgnore
 private List<Bookings> booking=new ArrayList<>();
 
 
 
 public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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




public User(String name, String email, String password, UserRole userRole, List<Bookings> booking) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.userRole = userRole;
	this.booking = booking;
}

public User() {
	
}
 
 
 

}
