package com.san.net.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.san.net.domain.AddressMongoDomain;
import com.san.net.domain.HotelMongoDomain;
import com.san.net.domain.Menu;
import com.san.net.domain.ReviewMongoDomain;
import com.san.net.domain.UserRegistrationMongoDomain;
import com.san.net.repo.HotelRepository;
import com.san.net.repo.UserRegistrationRepository;

@Component
public class CommandLineService  implements CommandLineRunner   {

	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	UserRegistrationRepository userRepo;

	public void run(String... args) throws Exception {
		System.out.println("run command line");

		ReviewMongoDomain goodReview = new ReviewMongoDomain("good");
		ReviewMongoDomain betterReview = new ReviewMongoDomain("better");
		ReviewMongoDomain bestReview = new ReviewMongoDomain("best");
		ReviewMongoDomain okReview = new ReviewMongoDomain("ok");
		ReviewMongoDomain neautralReview = new ReviewMongoDomain("neutaral");

		AddressMongoDomain puneAdrress = new AddressMongoDomain("Pune wakad");
		AddressMongoDomain mumbaiAdrress = new AddressMongoDomain("Mumbai bandra");
		AddressMongoDomain bangaloreAdrress = new AddressMongoDomain("Bangalore whitefield");
		AddressMongoDomain delhiAddress = new AddressMongoDomain("Delhi cannaught place");
		AddressMongoDomain biharAddress = new AddressMongoDomain("Bihar patna");
		AddressMongoDomain nasikAddress = new AddressMongoDomain("Nasik ahmadpur");
		
		AddressMongoDomain puneAdrress1 = new AddressMongoDomain("Pune dehu road");
		AddressMongoDomain mumbaiAdrress1 = new AddressMongoDomain("Mumbai mulund");
		AddressMongoDomain bangaloreAdrress1 = new AddressMongoDomain("Bangalore electronic city");
		AddressMongoDomain delhiAddress1 = new AddressMongoDomain("Delhi uttam nagar");
		AddressMongoDomain biharAddress1 = new AddressMongoDomain("Bihar siwan");
		AddressMongoDomain nasikAddress1 = new AddressMongoDomain("Nasik dighapur");
		
		Menu monday=new Menu();
		monday.setBreakfast("Idli Dosa");
		monday.setLunch("Veg Thali");
		monday.setDinner("Maharashtra Special Thali");
		monday.setDay("Monday");
		
		Menu tueday=new Menu();
		tueday.setBreakfast("Poha");
		tueday.setLunch("Non Veg Thali");
		tueday.setDinner("Dinner Special Thali");
		tueday.setDay("Tueday");
		
		Menu wednesday=new Menu();
		wednesday.setBreakfast("Puri Sabji");
		wednesday.setLunch("Gujrati Veg Thali");
		wednesday.setDinner("veg Special Thali");
		wednesday.setDay("Wednesday");
		
		List<Menu> menus=new ArrayList<>();
		menus.add(monday);
		menus.add(tueday);
		menus.add(wednesday);

		HotelMongoDomain a = new HotelMongoDomain("Punewale", 100, puneAdrress, Arrays.asList(bestReview, betterReview),menus);
		HotelMongoDomain b = new HotelMongoDomain("Bangalorewale", 200, bangaloreAdrress, Arrays.asList(goodReview, betterReview),menus);
		HotelMongoDomain c = new HotelMongoDomain("Mumbaiwale", 300, mumbaiAdrress, Arrays.asList(bestReview, goodReview),menus);
		HotelMongoDomain d = new HotelMongoDomain("Delhiwale", 400, delhiAddress, Arrays.asList(bestReview, okReview),menus);
		HotelMongoDomain e = new HotelMongoDomain("Biharwale", 500, biharAddress, Arrays.asList(neautralReview, goodReview),menus);
		HotelMongoDomain f = new HotelMongoDomain("Nasikwale", 700, nasikAddress, Arrays.asList(neautralReview, goodReview),null);
		
		HotelMongoDomain g = new HotelMongoDomain("Punewale", 100, puneAdrress1, Arrays.asList(bestReview, betterReview),menus);
		HotelMongoDomain h = new HotelMongoDomain("Bangalorewale", 200, bangaloreAdrress1, Arrays.asList(goodReview, betterReview),menus);
		HotelMongoDomain i = new HotelMongoDomain("Mumbaiwale", 300, mumbaiAdrress1, Arrays.asList(bestReview, goodReview),menus);
		HotelMongoDomain j = new HotelMongoDomain("Delhiwale", 400, delhiAddress1, Arrays.asList(bestReview, okReview),menus);
		HotelMongoDomain k = new HotelMongoDomain("Biharwale", 500, biharAddress1, Arrays.asList(neautralReview, goodReview),menus);
		HotelMongoDomain l = new HotelMongoDomain("Nasikwale", 700, nasikAddress1, Arrays.asList(neautralReview, goodReview),null);
		
		List<HotelMongoDomain> hotels = Arrays.asList(a, b, c, d, e,f,g, h, i, j, k,l);
		hotelRepository.deleteAll();

		hotelRepository.saveAll(hotels);

//		UserRegistrationMongoDomain userDomain = new UserRegistrationMongoDomain("sunil",
//				"sunilkumaryadavjava@gmail.com", "122345", "Male", "i love java programming", "15011986", true,
//				"developer");
//		userRepo.save(userDomain);

	}

}
