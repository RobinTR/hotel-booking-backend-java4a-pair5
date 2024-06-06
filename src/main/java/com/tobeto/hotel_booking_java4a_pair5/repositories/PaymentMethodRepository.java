package com.tobeto.hotel_booking_java4a_pair5.repositories;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
}
