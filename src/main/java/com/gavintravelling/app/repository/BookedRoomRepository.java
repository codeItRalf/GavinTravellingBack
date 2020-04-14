package com.gavintravelling.app.repository;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, BookedRoomsId> {

    @Query("SELECT b.room.id FROM BookedRoom b WHERE (:startDate BETWEEN b.startDate AND  b.endDate )OR" +
            " (:endDate BETWEEN b.startDate AND b.endDate) OR(:startDate <= b.startDate AND :endDate >= b.endDate)")
     List<Long> getBookedRoomWithinDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

// WHERE :startDate BETWEEN b.startDate AND b.endDate OR :endDate BETWEEN b.startDate AND b.endDate OR :startDate < b.startDate AND :endDate > b.endDate
}