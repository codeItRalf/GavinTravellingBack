package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.Customer;
import com.gavintravelling.app.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}