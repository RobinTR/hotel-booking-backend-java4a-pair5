package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePaymentByCardRequest {
    @NotNull(message = "You must enter an id.")
    private Integer id;

    @NotNull(message = "You must enter a payment method id.")
    private Integer paymentMethodId;

    @Size(max = 19, message = "Card number  must be maximum 19 characters")
    private String cardNumber;

    @Size(min = 5, max = 5, message = "Card expiration date must be  5 characters")
    private String cardExpirationDate;

    @Size(max = 4, message = "Cvv must be maximum 4 characters")
    private String cvv;
}
