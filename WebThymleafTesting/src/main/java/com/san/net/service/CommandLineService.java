package com.san.net.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.san.net.domain.AddressMongoDomain;
import com.san.net.domain.HotelMongoDomain;
import com.san.net.domain.ReviewMongoDomain;
import com.san.net.domain.UserRegistrationMongoDomain;
import com.san.net.repo.HotelRepository;
import com.san.net.repo.UserRegistrationRepository;

@Component
public class CommandLineService implements CommandLineRunner  {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	UserRegistrationRepository userRepo;

	public void run(String... args) throws Exception {
		System.out.println("run command line");
		
		ReviewMongoDomain goodReview=new ReviewMongoDomain("good");
		ReviewMongoDomain betterReview=new ReviewMongoDomain("better");
		ReviewMongoDomain bestReview=new ReviewMongoDomain("best");
		ReviewMongoDomain okReview=new ReviewMongoDomain("ok");
		ReviewMongoDomain neautralReview=new ReviewMongoDomain("neutaral");
		
		AddressMongoDomain puneAdrress=new AddressMongoDomain("Pune");
		AddressMongoDomain mumbaiAdrress=new AddressMongoDomain("Mumbai");
		AddressMongoDomain bangaloreAdrress=new AddressMongoDomain("Bangalore");
		AddressMongoDomain delhiAddress=new AddressMongoDomain("Delhi");
		AddressMongoDomain biharAddress=new AddressMongoDomain("Bihar");
		
		HotelMongoDomain a=new HotelMongoDomain("A",100,puneAdrress,Arrays.asList(bestReview,betterReview));
		HotelMongoDomain b=new HotelMongoDomain("B",200,mumbaiAdrress,Arrays.asList(goodReview,betterReview));
		HotelMongoDomain c=new HotelMongoDomain("C",300,bangaloreAdrress,Arrays.asList(bestReview,goodReview));
		HotelMongoDomain d=new HotelMongoDomain("d",400,delhiAddress,Arrays.asList(bestReview,okReview));
		HotelMongoDomain e=new HotelMongoDomain("e",500,biharAddress,Arrays.asList(neautralReview,goodReview));
		
		List<HotelMongoDomain> hotels=Arrays.asList(a,b,c,d,e);
		
		hotelRepository.deleteAll();
		
		hotelRepository.saveAll(hotels);
		
		UserRegistrationMongoDomain userDomain=new UserRegistrationMongoDomain("sunil", "sunilkumaryadavjava@gmail.com", "122345", "Male", "i love java programming", "15011986", true, "developer");
		userRepo.save(userDomain);
		
	}

}
