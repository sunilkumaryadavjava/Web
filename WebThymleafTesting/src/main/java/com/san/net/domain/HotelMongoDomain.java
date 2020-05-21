package com.san.net.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HotelDB")
public class HotelMongoDomain {

	@Id
	String id;
	String name;
	@Indexed(direction = IndexDirection.ASCENDING)
	int pricePerNight;
	AddressMongoDomain address;
	List<ReviewMongoDomain> review;
	List<Menu> menu;
	
	public HotelMongoDomain(){}
	
	public HotelMongoDomain(String name, int pricePerNight, AddressMongoDomain address, List<ReviewMongoDomain> review,List<Menu> menu) {
		super();
		this.name = name;
		this.pricePerNight = pricePerNight;
		this.address = address;
		this.review = review;
		this.menu=menu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(int pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public AddressMongoDomain getAddress() {
		return address;
	}

	public void setAddress(AddressMongoDomain address) {
		this.address = address;
	}

	public List<ReviewMongoDomain> getReview() {
		return review;
	}

	public void setReview(List<ReviewMongoDomain> review) {
		this.review = review;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
	
}
