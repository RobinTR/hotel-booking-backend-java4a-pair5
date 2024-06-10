package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllPaymentByCardResponse {
    private String paymentMethodName;
    private String cardNumber;
    private String expirationMonth;
    private String expirationYear;
    private String cvv;
}
