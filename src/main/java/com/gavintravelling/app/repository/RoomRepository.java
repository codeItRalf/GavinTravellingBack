package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Hotel;
import com.gavintravelling.app.entity.Room;
import com.gavintravelling.app.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> getRoomsByRoomType_HotelIn(Collection<Hotel> roomType_hotel);

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT br.room.id FROM BookedRoom br WHERE (:startDate BETWEEN br.startDate AND  br.endDate )OR(:endDate BETWEEN br.startDate AND br.endDate) OR(:startDate <= br.startDate AND :endDate >= br.endDate)) AND r.roomType.hotel.id = :hotelId")
    List<Room> listAvailableRoomsBetweenDatesWithHotelId(Date startDate, Date endDate, Long hotelId);

}