package com.tobeto.hotel_booking_java4a_pair5.controllers;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentByCardMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentByCardMapper;
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
        paymentByCardService.add(request);

        return new SuccessResponse(PaymentByCardMessages.PAYMENT_BY_CARD_ADDED);
    }

    @PutMapping
    public Response update(@RequestBody @Valid UpdatePaymentByCardRequest request) {
        paymentByCardService.update(request);

        return new SuccessResponse(PaymentByCardMessages.PAYMENT_BY_CARD_UPDATED);
    }

    @DeleteMapping
    public Response delete(@RequestParam Integer id) {
        paymentByCardService.delete(id);

        return new SuccessResponse(PaymentByCardMessages.PAYMENT_BY_CARD_DELETED);
    }

    @GetMapping
    public DataResponse<List<GetAllPaymentByCardResponse>> getAll() {
        List<PaymentByCard> paymentByCards = paymentByCardService.getAll();
        List<GetAllPaymentByCardResponse> getAllPaymentByCardResponseList = PaymentByCardMapper.INSTANCE.getAllPaymentByCardResponseListFromPaymentByCards(paymentByCards);

        return new SuccessDataResponse<>(getAllPaymentByCardResponseList, PaymentByCardMessages.PAYMENT_BY_CARD_LISTED);
    }

    @GetMapping("/{getById}")
    public DataResponse<GetByIdPaymentByCardResponse> getById(@PathVariable Integer getById) {
        PaymentByCard paymentByCard = paymentByCardService.getById(getById);
        GetByIdPaymentByCardResponse getByIdPaymentByCardResponse = PaymentByCardMapper.INSTANCE.getByIdPaymentByCardResponseFromPaymentByCard(paymentByCard);

        return new SuccessDataResponse<>(getByIdPaymentByCardResponse, PaymentByCardMessages.PAYMENT_BY_CARD_LISTED);
    }
}
