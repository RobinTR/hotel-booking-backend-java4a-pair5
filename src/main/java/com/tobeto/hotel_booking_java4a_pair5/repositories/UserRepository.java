package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
