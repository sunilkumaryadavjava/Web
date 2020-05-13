package com.san.net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.net.domain.UserRegistrationMongoDomain;
import com.san.net.repo.UserRegistrationRepository;

@Service
public class UserRegistrationService {
	
	
	@Autowired
	UserRegistrationRepository userRepo;
	
	
	public UserRegistrationMongoDomain insert(UserRegistrationMongoDomain user) {
		return userRepo.insert(user);
	}

}
