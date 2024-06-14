package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateBookingRequest {
    @NotNull(message = "You must enter an id.")
    private Integer id;

    @NotNull(message = "You must enter a hotel id.")
    private Integer hotelId;

    @NotNull(message = "You must enter a guest id.")
    private Integer guestId;

    @NotNull(message = "You must enter a payment method id.")
    private Integer paymentMethodId;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;
}
