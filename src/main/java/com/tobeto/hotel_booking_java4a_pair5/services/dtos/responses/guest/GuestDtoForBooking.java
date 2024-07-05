package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user.UserDtoForBooking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestDtoForBooking {
    private Integer id;
    private UserDtoForBooking user;
}
