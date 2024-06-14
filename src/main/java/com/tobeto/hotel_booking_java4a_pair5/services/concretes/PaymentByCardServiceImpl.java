package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.utils.EncryptionUtil;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentByCardRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentByCardMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentByCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentByCardServiceImpl implements PaymentByCardService {
    private final PaymentByCardRepository paymentByCardRepository;

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
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));
        paymentByCardRepository.delete(paymentByCard);

        return PaymentByCardMessages.PAYMENTBYCARD_DELETED;
    }

    @Override
    public List<PaymentByCard> getAll() {return paymentByCardRepository.findAll();

    }

    @Override
    public PaymentByCard getById(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));

        return paymentByCard;
    }
}
