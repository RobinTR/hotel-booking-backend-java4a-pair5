package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentMethodService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetAllPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetByIdPaymentMethodResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paymentmethods")
@AllArgsConstructor
public class PaymentMethodsController {
    private PaymentMethodService paymentMethodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response add(@RequestBody @Valid AddPaymentMethodRequest request) {
        return paymentMethodService.add(request);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdatePaymentMethodRequest request) {
        return paymentMethodService.update(request);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        return paymentMethodService.delete(id);
    }

    @GetMapping
    public DataResponse<List<GetAllPaymentMethodResponse>> getAll() {
        return paymentMethodService.getAll();
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdPaymentMethodResponse> getById(@PathVariable Integer getById) {
        return paymentMethodService.getById(getById);
    }
}
