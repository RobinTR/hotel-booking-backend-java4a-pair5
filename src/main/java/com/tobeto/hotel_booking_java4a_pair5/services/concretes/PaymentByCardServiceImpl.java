package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentByCardRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentByCardService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentByCardMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentByCardMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentByCardServiceImpl implements PaymentByCardService {
    private PaymentByCardRepository paymentByCardRepository;

    @Override
    public Result add(AddPaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromAddRequest(request);
        paymentByCard = paymentByCardRepository.save(paymentByCard);

        return new SuccessResult(PaymentByCardMessages.PAYMENTBYCARD_ADDED);
    }

    @Override
    public Result update(UpdatePaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromUpdateRequest(request);
        paymentByCard = paymentByCardRepository.save(paymentByCard);

        return new SuccessResult(PaymentByCardMessages.PAYMENTBYCARD_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));
        paymentByCardRepository.deleteById(paymentByCard.getId());

        return new SuccessResult(PaymentByCardMessages.PAYMENTBYCARD_DELETED);
    }

    @Override
    public DataResult<List<GetAllPaymentByCardResponse>> getAll() {
        List<PaymentByCard> paymentByCards = paymentByCardRepository.findAll();
        List<GetAllPaymentByCardResponse> response = PaymentByCardMapper.INSTANCE.getAllPaymentByCardResponseList(paymentByCards);

        return new SuccessDataResult<>(response, PaymentByCardMessages.PAYMENTBYCARD_LISTED);
    }

    @Override
    public DataResult<GetByIdPaymentByCardResponse> getById(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));
        GetByIdPaymentByCardResponse response = PaymentByCardMapper.INSTANCE.getByIdPaymentByCardResponse(paymentByCard);

        return new SuccessDataResult<>(response, PaymentByCardMessages.PAYMENTBYCARD_LISTED);
    }
}
