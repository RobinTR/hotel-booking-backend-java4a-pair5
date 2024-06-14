package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AddBookingRequest {
    @NotNull(message = "You must enter a hotel id.")
    private Integer hotelId;

    @NotNull(message = "You must enter a guest id.")
    private Integer guestId;

    private List<Integer> roomIds;

    @NotNull(message = "You must enter a payment method id.")
    private Integer paymentMethodId;

    private LocalDate startDate;

    private LocalDate endDate;
}
