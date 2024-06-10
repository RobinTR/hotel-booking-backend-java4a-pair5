package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPaymentByCardRequest {
    @NotNull(message = "You must enter a payment method id.")
    private Integer paymentMethodId;

    @Size(max = 19, message = "Card number  must be maximum 19 characters")
    private String cardNumber;

    @Size(min = 2, max = 2, message = "Card expiration year must be 2 characters")
    private String expirationMonth;

    @Size(min = 2, max = 2, message = "Card expiration year must be 2 characters")
    private String expirationYear;

    @Size(max = 4, message = "Cvv must be maximum 4 characters")
    private String cvv;
}
