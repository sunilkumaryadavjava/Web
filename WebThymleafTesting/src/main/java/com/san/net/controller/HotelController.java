package com.san.net.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.net.domain.HotelMongoDomain;
import com.san.net.model.HotelModel;
import com.san.net.service.HotelService;

//@RestController
@Controller
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	
	@RequestMapping(value = "/getHotelDetails",method = RequestMethod.GET)
	public List<HotelMongoDomain> getHotelDetails(){
		return hotelService.getHotelsDetails();
	}
	
	@RequestMapping(name = "test",value = "/test",method = RequestMethod.GET)
	public String isAlive(){
		return "i am running";
	}
	
	@RequestMapping(value="createHotelDetails", method= RequestMethod.POST)
	public HotelMongoDomain createRecord(@RequestBody HotelMongoDomain hotel,HttpServletRequest req) {
		return hotelService.createRecord(hotel);
	}
	
	@RequestMapping(value="updateHotelDetails", method= RequestMethod.PUT)
	public HotelMongoDomain updateRecord(@RequestBody HotelMongoDomain hotel,HttpServletRequest req) {
		return hotelService.updateRecord(hotel);
	}
	
	@RequestMapping(value="deleteHotelDetailsById/{id}", method= RequestMethod.DELETE)
	public void deleteHotelDetailsById(@PathVariable("id")String id) {
		 hotelService.deleteHotelDetailsById(id);
	}
	
	@RequestMapping(value="findById/{id}", method= RequestMethod.GET)
	public Optional<HotelMongoDomain> findById(@PathVariable("id")String id){
		return hotelService.findById(id);
	}
	
	@RequestMapping(value="findByPricePerNightLessThan",method=RequestMethod.GET)
	public List<HotelMongoDomain> findByPricePerNightLessThan(@RequestParam("amount")int amount){
		return hotelService.findByPricePerNightLessThan(amount);
	}
	
	@RequestMapping(value="getHotelByAddressCity",method=RequestMethod.GET)
	public List<HotelMongoDomain> getHotelByAddressCity(@RequestParam("city")String city){
//		QHotel q=new QHotel("hotel");
		return hotelService.findHotelByAddressCity(city);
	}
//	
//	@RequestMapping(value="findHotelByAddressCity",method=RequestMethod.GET)
//	public List<HotelMongoDomain> findHotelByAddressCity(@RequestParam("city")String city){
//		return hotelService.findHotelByAddressCity(city);
//	}
//	
	
	@GetMapping(value="/hotelInfo")
	public String hotelInfo(Model model) {
		HotelModel hotel=new HotelModel();
		model.addAttribute("hotelModel", hotel);
		return "hotelInputPage";
	}
	
	@PostMapping(value="/hotelForm")
	public String hotelDetails(@ModelAttribute("hotelModels") HotelModel ma, Model model) {
		String hotelName=ma.getHotelName();
		List<HotelMongoDomain> hotelList=hotelService.findByName(hotelName);
//		if(Objects.isNull(hotel))
//			hotel=new HotelMongoDomain();
		model.addAttribute("hotel",hotelList);
		
		return "hotelOutputPage";
	}
	
}
