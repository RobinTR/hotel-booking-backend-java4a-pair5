package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdSupportResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private boolean isAnswered;
    private String answer;
}
