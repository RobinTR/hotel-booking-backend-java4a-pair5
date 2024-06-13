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
    private SecretKey secretKey;

    @Override
    public Response add(AddPaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromAddRequest(request);

        secretKey = EncryptionUtil.generateAESKey();
        String encryptedCardNumber = EncryptionUtil.encryptCardNumber(request.getCardNumber(), secretKey);
        String encryptedCvv = EncryptionUtil.encryptCvv(request.getCvv(), secretKey);
        paymentByCard.setCardNumber(encryptedCardNumber);
        paymentByCard.setCvv(encryptedCvv);

        paymentByCardRepository.save(paymentByCard);

        return new SuccessResponse(PaymentByCardMessages.PAYMENTBYCARD_ADDED);
    }

    @Override
    public Response update(UpdatePaymentByCardRequest request) {
        PaymentByCard paymentByCard = PaymentByCardMapper.INSTANCE.paymentByCardFromUpdateRequest(request);

        secretKey = EncryptionUtil.generateAESKey();
        String encryptedCardNumber = EncryptionUtil.encryptCardNumber(request.getCardNumber(), secretKey);
        String encryptedCvv = EncryptionUtil.encryptCvv(request.getCvv(), secretKey);
        paymentByCard.setCardNumber(encryptedCardNumber);
        paymentByCard.setCvv(encryptedCvv);

        paymentByCardRepository.save(paymentByCard);

        return new SuccessResponse(PaymentByCardMessages.PAYMENTBYCARD_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));
        paymentByCardRepository.deleteById(paymentByCard.getId());

        return new SuccessResponse(PaymentByCardMessages.PAYMENTBYCARD_DELETED);
    }

    @Override
    public DataResponse<List<GetAllPaymentByCardResponse>> getAll() {
        List<PaymentByCard> paymentByCards = paymentByCardRepository.findAll();
        List<GetAllPaymentByCardResponse> response = PaymentByCardMapper.INSTANCE.getAllPaymentByCardResponseList(paymentByCards);

        return new SuccessDataResponse<>(response, PaymentByCardMessages.PAYMENTBYCARD_LISTED);
    }

    @Override
    public DataResponse<GetByIdPaymentByCardResponse> getById(Integer id) {
        PaymentByCard paymentByCard = paymentByCardRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentByCardMessages.PAYMENTBYCARD_NOT_FOUND));
        GetByIdPaymentByCardResponse response = PaymentByCardMapper.INSTANCE.getByIdPaymentByCardResponse(paymentByCard);

        return new SuccessDataResponse<>(response, PaymentByCardMessages.PAYMENTBYCARD_LISTED);
    }
}
