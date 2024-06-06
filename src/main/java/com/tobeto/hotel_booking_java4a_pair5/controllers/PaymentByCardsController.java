package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paymentbycards")
@AllArgsConstructor
public class PaymentByCardsController {
    private PaymentByCardService paymentByCardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Result add(@RequestBody @Valid AddPaymentByCardRequest request) {
        return paymentByCardService.add(request);
    }

    @PutMapping
    public Result update(@RequestBody @Valid UpdatePaymentByCardRequest request) {
        return paymentByCardService.update(request);
    }
}
