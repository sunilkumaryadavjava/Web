package com.san.net.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.san.net.domain.UserRegistrationMongoDomain;
import com.san.net.model.UserRegistration;
import com.san.net.service.UserRegistrationService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	UserRegistrationService userService;
	
	@GetMapping(value = "/register")
	public String showRegForm(Model model) {
		List<String> professionList=Arrays.asList("Developer","Designer","Architect");
		model.addAttribute("professionList", professionList);
		UserRegistration user=new UserRegistration();
		model.addAttribute("userRegistration", user);
		return "registrationPage";
		
	}
	@PostMapping(value ="/registerForm")
	public String doRegistration(@ModelAttribute("userRegistration") UserRegistration ur) {
		System.out.println(ur);
		UserRegistrationMongoDomain domain=new UserRegistrationMongoDomain();
		domain.setDob(ur.getDob());
		domain.setName(ur.getName());
		domain.setGender(ur.getGender());
		domain.setEmail(ur.getEmail());
		domain.setNote(ur.getNote());
		domain.setPassword(ur.getPassword());
		domain.setProfessional(ur.getProfessional());
		domain.setMarried(ur.getMarried());
		userService.insert(domain);
		return "registrationSuccess";
		
	}
	

}
