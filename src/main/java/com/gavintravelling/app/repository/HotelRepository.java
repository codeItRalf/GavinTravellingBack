package com.gavintravelling.app.repository;

import com.gavintravelling.app.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> getHotelsByDistanceToBeachIsLessThanEqualAndDistanceToCenterIsLessThanEqualAndCity_Name(double distanceToBeach, double distanceToCenter, String city_name);



//    @Query("SELECT b.room.id FROM BookedRoom b WHERE (:startDate BETWEEN b.startDate AND  b.endDate )OR" +
//            " (:endDate BETWEEN b.startDate AND b.endDate) OR(:startDate <= b.startDate AND :endDate >= b.endDate)")
//
}