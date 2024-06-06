package com.tobeto.hotel_booking_java4a_pair5.repositories;


import com.tobeto.hotel_booking_java4a_pair5.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
