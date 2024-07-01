package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddCitizenRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
