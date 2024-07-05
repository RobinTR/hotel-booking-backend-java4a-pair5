package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.citizenofbooking;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetCitizenOfBookingResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
