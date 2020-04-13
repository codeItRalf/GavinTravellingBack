package com.gavintravelling.app.repository;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, BookedRoomsId> {

}