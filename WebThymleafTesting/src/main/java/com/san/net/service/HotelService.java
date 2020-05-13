package com.san.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.net.model.Hotel;
import com.san.net.repo.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	public List<Hotel> getHotelsDetails(){
		return hotelRepository.findAll();
	}
	
	public Hotel createRecord(Hotel hotel) {
		return hotelRepository.insert(hotel);
	}
	public Hotel updateRecord(Hotel hotel) {
		return hotelRepository.save(hotel);
	}
	public void deleteHotelDetailsById(String id) {
		 hotelRepository.deleteById(id);
	}

	public Optional<Hotel> findById(String id) {
		return hotelRepository.findById(id);
	}
	
	public List<Hotel> findByPricePerNightLessThan(int amount){
		return hotelRepository.findByPricePerNightLessThan(amount);
	}
	
	public List<Hotel> findHotelByAddressCity(String city){
		return hotelRepository.findHotelByAddressCity(city);
	}
	
	public List<Hotel> getHotelByAddressCity(String city){
//		QHotel q=new QHotel("hotel");
//		BooleanExpression 
		
		return hotelRepository.getHotelByAddressCity(city);
	}
	
	
}
