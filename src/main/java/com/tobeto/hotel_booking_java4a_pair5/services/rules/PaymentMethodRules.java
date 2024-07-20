package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentMethodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentMethodMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMethodRules {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod findById(Integer id) {
        return paymentMethodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PaymentMethodMessages.PAYMENT_METHOD_NOT_FOUND));
    }
}
