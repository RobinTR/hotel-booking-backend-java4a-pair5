package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
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
    public Response add(@RequestBody @Valid AddPaymentByCardRequest request) {
        return paymentByCardService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdatePaymentByCardRequest request) {
        return paymentByCardService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return paymentByCardService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllPaymentByCardResponse>> getAll() {
        return paymentByCardService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdPaymentByCardResponse> getById(@PathVariable Integer getById) {
        return paymentByCardService.getById(getById);
    }
}
