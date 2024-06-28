package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBookingDateResponse {
    private Integer hotelId;
    private LocalDate startDate;
    private LocalDate endDate;
}
