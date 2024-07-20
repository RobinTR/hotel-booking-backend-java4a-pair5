package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentByCardRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentByCardMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentByCardMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.PaymentByCardRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentByCardServiceImpl implements PaymentByCardService {
    private final PaymentByCardRepository paymentByCardRepository;
    private final PaymentByCardRules paymentByCardRules;

    @Override
    public PaymentByCard add(AddPaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromAddRequest(request);
        paymentByCard = paymentByCardRepository.save(paymentByCard);

        return paymentByCard;
    }

    @Override
    public PaymentByCard update(UpdatePaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromUpdateRequest(request);
        paymentByCard = paymentByCardRepository.save(paymentByCard);

        return paymentByCard;
    }

    @Override
    public String delete(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRules.findById(id);
        paymentByCardRepository.delete(paymentByCard);

        return PaymentByCardMessages.PAYMENT_BY_CARD_DELETED;
    }

    @Override
    public List<PaymentByCard> getAll() {
        return paymentByCardRepository.findAll();
    }

    @Override
    public PaymentByCard getById(Integer id) {
        return paymentByCardRules.findById(id);
    }
}
