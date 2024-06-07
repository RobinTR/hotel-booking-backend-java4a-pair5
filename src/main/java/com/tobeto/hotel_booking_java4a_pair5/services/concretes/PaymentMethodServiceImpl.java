package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentMethodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentMethodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentMethodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetAllPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetByIdPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentMethodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PaymentMethodServiceImpl implements PaymentMethodService {
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public Result add(AddPaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromAddRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return new SuccessResult(PaymentMethodMessages.PAYMENTMETHOD_ADDED);
    }

    @Override
    public Result update(UpdatePaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromUpdateRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return new SuccessResult(PaymentMethodMessages.PAYMENTMETHOD_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllPaymentMethodResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdPaymentMethodResponse> getById(Integer id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentMethodMessages.PAYMENTMETHOD_NOT_FOUND));
        GetByIdPaymentMethodResponse response = PaymentMethodMapper.INSTANCE.getByIdPaymentMethodResponse(paymentMethod);

        return new SuccessDataResult<>(response, PaymentMethodMessages.PAYMENTMETHOD_LISTED);
    }
}