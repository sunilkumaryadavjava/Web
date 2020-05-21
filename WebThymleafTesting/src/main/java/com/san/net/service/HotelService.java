package com.san.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.net.domain.HotelMongoDomain;
import com.san.net.repo.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	public List<HotelMongoDomain> getHotelsDetails(){
		return hotelRepository.findAll();
	}
	
	public HotelMongoDomain createRecord(HotelMongoDomain hotel) {
		return hotelRepository.insert(hotel);
	}
	public HotelMongoDomain updateRecord(HotelMongoDomain hotel) {
		return hotelRepository.save(hotel);
	}
	public void deleteHotelDetailsById(String id) {
		 hotelRepository.deleteById(id);
	}

	public Optional<HotelMongoDomain> findById(String id) {
		return hotelRepository.findById(id);
	}
	
	public List<HotelMongoDomain> findByPricePerNightLessThan(int amount){
		return hotelRepository.findByPricePerNightLessThan(amount);
	}
	
	public List<HotelMongoDomain> findHotelByAddressCity(String city){
		return hotelRepository.findHotelByAddressCity(city);
	}
//	
//	public List<HotelMongoDomain> getHotelByAddressCity(String city){
////		QHotel q=new QHotel("hotel");
////		BooleanExpression 
//		
//		return hotelRepository.getHotelByAddressCity(city);
//	}

	public List<HotelMongoDomain> findByName(String hotelName) {
		return hotelRepository.findByName(hotelName);
		
	}
	
	
}
