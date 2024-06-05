package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateGuestRequest {
    private Integer id;
    private Integer paymentByCardId;
}
