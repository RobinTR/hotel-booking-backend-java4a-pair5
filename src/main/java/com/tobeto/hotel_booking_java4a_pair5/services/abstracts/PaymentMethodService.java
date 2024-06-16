package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethod add(AddPaymentMethodRequest request);

    PaymentMethod update(UpdatePaymentMethodRequest request);

    String delete(Integer id);

    List<PaymentMethod> getAll();

    PaymentMethod getById(Integer id);
}
