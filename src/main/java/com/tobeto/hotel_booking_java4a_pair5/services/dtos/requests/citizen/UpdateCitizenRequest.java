package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateCitizenRequest {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDate;
}
