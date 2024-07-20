package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentByCardRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentByCardMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentByCardRules {
    private final PaymentByCardRepository paymentByCardRepository;

    public PaymentByCard findById(Integer id) {
        return paymentByCardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(PaymentByCardMessages.PAYMENT_BY_CARD_NOT_FOUND));
    }
}
