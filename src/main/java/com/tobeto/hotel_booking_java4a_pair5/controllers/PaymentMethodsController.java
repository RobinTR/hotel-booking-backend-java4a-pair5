package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentMethodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentMethodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetAllPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetByIdPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentMethodMapper;
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
        paymentMethodService.add(request);
        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdatePaymentMethodRequest request) {
        paymentMethodService.update(request);
        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        paymentMethodService.delete(id);

        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllPaymentMethodResponse>> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodService.getAll();
        List<GetAllPaymentMethodResponse> getAllPaymentMethodResponseList = PaymentMethodMapper.INSTANCE.getAllPaymentMethodResponseList(paymentMethods);

        return new SuccessDataResponse<>(getAllPaymentMethodResponseList, PaymentMethodMessages.PAYMENTMETHOD_LISTED);

    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdPaymentMethodResponse> getById(@PathVariable Integer getById) {
        PaymentMethod paymentMethod = paymentMethodService.getById(getById);
        GetByIdPaymentMethodResponse getByIdPaymentMethodResponse = PaymentMethodMapper.INSTANCE.getByIdPaymentMethodResponse(paymentMethod);

        return new SuccessDataResponse<>(getByIdPaymentMethodResponse, PaymentMethodMessages.PAYMENTMETHOD_LISTED);
    }
}
