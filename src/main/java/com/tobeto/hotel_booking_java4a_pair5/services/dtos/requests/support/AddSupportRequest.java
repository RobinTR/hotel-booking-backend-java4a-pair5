package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddSupportRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private boolean isAnswered;
    private String answer;
}
