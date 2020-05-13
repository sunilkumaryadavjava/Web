package com.san.net.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.san.net.model.Address;
import com.san.net.model.Hotel;
import com.san.net.model.Review;
import com.san.net.repo.HotelRepository;

@Component
public class CommandLineService implements CommandLineRunner {
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run command line");
		
		Review goodReview=new Review("good");
		Review betterReview=new Review("better");
		Review bestReview=new Review("best");
		Review okReview=new Review("ok");
		Review neautralReview=new Review("neutaral");
		
		Address puneAdrress=new Address("Pune");
		Address mumbaiAdrress=new Address("Mumbai");
		Address bangaloreAdrress=new Address("Bangalore");
		Address delhiAddress=new Address("Delhi");
		Address biharAddress=new Address("Bihar");
		
		Hotel a=new Hotel("A",100,puneAdrress,Arrays.asList(bestReview,betterReview));
		Hotel b=new Hotel("B",200,mumbaiAdrress,Arrays.asList(goodReview,betterReview));
		Hotel c=new Hotel("C",300,bangaloreAdrress,Arrays.asList(bestReview,goodReview));
		Hotel d=new Hotel("d",400,delhiAddress,Arrays.asList(bestReview,okReview));
		Hotel e=new Hotel("e",500,biharAddress,Arrays.asList(neautralReview,goodReview));
		
		List<Hotel> hotels=Arrays.asList(a,b,c,d,e);
		
		hotelRepository.deleteAll();
		
		hotelRepository.saveAll(hotels);
		
		
	}

}
