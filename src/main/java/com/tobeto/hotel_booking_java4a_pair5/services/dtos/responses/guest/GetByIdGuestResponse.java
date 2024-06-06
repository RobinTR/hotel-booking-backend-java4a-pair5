package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdGuestResponse {
    private Integer id;
    private String paymentByCardName;
}
