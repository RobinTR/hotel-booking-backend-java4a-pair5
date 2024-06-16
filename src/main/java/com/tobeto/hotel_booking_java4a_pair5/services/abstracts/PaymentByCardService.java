package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;

import java.util.List;

public interface PaymentByCardService {
    PaymentByCard add(AddPaymentByCardRequest request);

    PaymentByCard update(UpdatePaymentByCardRequest request);

    String delete(Integer id);

    List<PaymentByCard> getAll();

    PaymentByCard getById(Integer id);
}
