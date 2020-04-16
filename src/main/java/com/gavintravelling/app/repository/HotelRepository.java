package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> getHotelsByPoolAndNightEntertainmentAndChildrenClubAndRestaurantAndDistanceToBeachIsLessThanEqualAndDistanceToCenterIsLessThanEqualAndCity_Name(boolean pool, boolean nightEntertainment, boolean childrenClub, boolean restaurant, double distanceToBeach, double distanceToCenter, String city_name);

    List<Hotel> getHotelsByCity_Name(String city_name);
}