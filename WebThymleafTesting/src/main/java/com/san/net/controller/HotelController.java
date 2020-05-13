package com.san.net.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.net.model.Hotel;
import com.san.net.service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	
	@RequestMapping(value = "/getHotelDetails",method = RequestMethod.GET)
	public List<Hotel> getHotelDetails(){
		return hotelService.getHotelsDetails();
	}
	
	@RequestMapping(name = "test",value = "/test",method = RequestMethod.GET)
	public String isAlive(){
		return "i am running";
	}
	
	@RequestMapping(value="createHotelDetails", method= RequestMethod.POST)
	public Hotel createRecord(@RequestBody Hotel hotel,HttpServletRequest req) {
		return hotelService.createRecord(hotel);
	}
	
	@RequestMapping(value="updateHotelDetails", method= RequestMethod.PUT)
	public Hotel updateRecord(@RequestBody Hotel hotel,HttpServletRequest req) {
		return hotelService.updateRecord(hotel);
	}
	
	@RequestMapping(value="deleteHotelDetailsById/{id}", method= RequestMethod.DELETE)
	public void deleteHotelDetailsById(@PathVariable("id")String id) {
		 hotelService.deleteHotelDetailsById(id);
	}
	
	@RequestMapping(value="findById/{id}", method= RequestMethod.GET)
	public Optional<Hotel> findById(@PathVariable("id")String id){
		return hotelService.findById(id);
	}
	
	@RequestMapping(value="findByPricePerNightLessThan",method=RequestMethod.GET)
	public List<Hotel> findByPricePerNightLessThan(@RequestParam("amount")int amount){
		return hotelService.findByPricePerNightLessThan(amount);
	}
	
	@RequestMapping(value="getHotelByAddressCity",method=RequestMethod.GET)
	public List<Hotel> getHotelByAddressCity(String city){
//		QHotel q=new QHotel("hotel");
		return hotelService.getHotelByAddressCity(city);
	}
	
	@RequestMapping(value="findHotelByAddressCity",method=RequestMethod.GET)
	public List<Hotel> findHotelByAddressCity(@RequestParam("city")String city){
		return hotelService.findHotelByAddressCity(city);
	}
	
}
