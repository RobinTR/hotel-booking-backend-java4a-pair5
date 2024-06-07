package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetAllAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address.GetByIdAddressResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    public Result delete(@RequestParam Integer id) {
        return paymentByCardService.delete(id);
    }

    @GetMapping
    public DataResult<List<GetAllPaymentByCardResponse>> getAll() {
        return paymentByCardService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResult<GetByIdPaymentByCardResponse> getById(@PathVariable Integer getById) {
        return paymentByCardService.getById(getById);
    }
}
