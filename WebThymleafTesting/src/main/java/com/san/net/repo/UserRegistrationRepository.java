package com.san.net.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.san.net.domain.UserRegistrationMongoDomain;

@Repository
public interface UserRegistrationRepository extends MongoRepository<UserRegistrationMongoDomain, String>{

// Optional<Hotel> findById(String id);
//List<Hotel> findByPricePerNightLessThan(int amount);
//
//@Query(value = "{address.city:?0}")
//List<Hotel> findHotelByAddressCity(String city);
//
//List<Hotel> getHotelByAddressCity(String city);





}
