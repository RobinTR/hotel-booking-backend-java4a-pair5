package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest;

import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGuestForRegisterRequest {
    private User user;
}
