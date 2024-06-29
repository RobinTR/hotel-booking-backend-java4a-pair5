package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCitizenOfBookingRequest {
    private Integer citizenId;
    private Integer bookingId;
}
