package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

  Iterable<RoomType> getRoomTypesByHotelId(Long hotel_id);

  @Query("SELECT new RoomType(roomType, MIN (price)) FROM RoomType WHERE hotel.id = :hotel_id GROUP BY roomType")
  List<RoomType> countRoomTypesByHotelId(Long hotel_id);

  @Query("SELECT rt FROM RoomType rt WHERE rt.id NOT IN (SELECT br.room.roomType.id FROM BookedRoom br WHERE (:startDate BETWEEN br.startDate AND  br.endDate )OR(:endDate BETWEEN br.startDate AND br.endDate) OR(:startDate <= br.startDate AND :endDate >= br.endDate)) AND rt.hotel.id = :hotelId")
  List<RoomType> listAvailableRoomsBetweenDatesWithHotelId(Date startDate, Date endDate, Long hotelId);

}