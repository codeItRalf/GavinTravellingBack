package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {

  Iterable<RoomType> getRoomTypesByHotelId(Long hotel_id);

}