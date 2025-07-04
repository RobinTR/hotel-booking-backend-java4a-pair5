package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GetByIdBookingResponse {
    private Integer id;
    private String hotelName;
    private String guestName;
    private String paymentMethodName;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private double totalCost;
}
