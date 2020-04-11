package com.gavintravelling.app.repository;


import com.gavintravelling.app.entity.City;
import com.gavintravelling.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}