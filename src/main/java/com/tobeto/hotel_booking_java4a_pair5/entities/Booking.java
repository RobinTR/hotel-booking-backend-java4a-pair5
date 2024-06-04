package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "bookings")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity {
    @Column(name = "hotel_id")
    private int hotelId;

    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "payment_method_id")
    private int paymentMethodId;

    @Column(name = "total_rooms_booked")
    private int totalRoomsBooked;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "duration_of_stay")
    private int durationOfStay;

    @Column(name = "check_in_date")
    private LocalDateTime checkInDate;

    @Column(name = "check_out_date")
    private LocalDateTime checkOutDate;

    @Column(name = "total_cost")
    private double totalCost;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
