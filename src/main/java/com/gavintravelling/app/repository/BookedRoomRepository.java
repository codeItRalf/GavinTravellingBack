package com.gavintravelling.app.repository;


import com.gavintravelling.app.embeddedId.BookedRoomsId;
import com.gavintravelling.app.entity.BookedRoom;
import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedRoomRepository extends JpaRepository<BookedRoom, BookedRoomsId> {

}