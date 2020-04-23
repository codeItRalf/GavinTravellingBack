package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

  Iterable<RoomType> getRoomTypesByHotelId(Long hotel_id);

  @Query("SELECT new RoomType(roomType, MIN (price)) FROM RoomType WHERE hotel.id = :hotel_id GROUP BY roomType")
  List<RoomType> countRoomTypesByHotelId(Long hotel_id);

}