package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdPaymentByCardResponse {
    private Integer paymentMethodId;
    private String cardNumber;
    private String cardExpirationDate;
    private String cvv;
}
