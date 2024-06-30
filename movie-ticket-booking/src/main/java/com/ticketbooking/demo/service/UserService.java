package com.ticketbooking.demo.service;

import com.ticketbooking.demo.entities.User;

public interface UserService {

	
	public User createUser(User user);
	
	
	public User findUserByJwt(String jwt);
	
}
