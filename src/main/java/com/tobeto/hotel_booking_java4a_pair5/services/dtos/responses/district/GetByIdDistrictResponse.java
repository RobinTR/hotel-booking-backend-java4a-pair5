package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GetByIdDistrictResponse {
    private Integer id;
    private String cityName;
    private String name;
}
