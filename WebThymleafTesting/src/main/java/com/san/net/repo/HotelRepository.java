package com.san.net.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.san.net.domain.HotelMongoDomain;

@Repository
public interface HotelRepository extends MongoRepository<HotelMongoDomain, String>/* ,QuerydslPredicateExecutor<Hotel> */{

 Optional<HotelMongoDomain> findById(String id);
List<HotelMongoDomain> findByPricePerNightLessThan(int amount);

@Query(value = "{address.city:?0}")
List<HotelMongoDomain> findHotelByAddressCity(String citys);
List<HotelMongoDomain> findByName(String hotelName);


}
