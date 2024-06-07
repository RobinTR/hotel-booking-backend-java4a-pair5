package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AddBookingRequest {
    @NotNull(message = "You must enter a hotel id.")
    private Integer hotelId;

    @NotNull(message = "You must enter a guest id.")
    private Integer guestId;

    @NotNull(message = "You must enter a payment method id.")
    private Integer paymentMethodId;

    @NotNull(message = "You must enter a total rooms booked.")
    @Positive(message = "Total rooms booked must be higher than 0.")
    private int totalRoomsBooked;

    private LocalDate date;

    @NotNull(message = "You must enter a duration of stay.")
    @Positive(message = "Duration of stay must be higher than 0.")
    private int durationOfStay;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    @NotNull(message = "You must enter a total cost.")
    @Positive(message = "Total cost must be higher than 0.")
    private double totalCost;
}
