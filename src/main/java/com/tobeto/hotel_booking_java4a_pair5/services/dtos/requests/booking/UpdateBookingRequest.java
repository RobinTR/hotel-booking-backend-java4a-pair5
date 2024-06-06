package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateBookingRequest {
    private Integer id;

    private Integer hotelId;

    private Integer guestId;

    private Integer paymentMethodId;

    private int totalRoomsBooked;

    private LocalDate date;

    private int durationOfStay;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private double totalCost;
}
