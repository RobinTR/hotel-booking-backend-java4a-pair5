package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.repositories.PaymentMethodRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.PaymentMethodService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.PaymentMethodMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.PaymentMethodMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PaymentMethodServiceImpl implements PaymentMethodService {
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod add(AddPaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromAddRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return paymentMethod;
    }

    @Override
    public PaymentMethod update(UpdatePaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromUpdateRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return paymentMethod;
    }

    @Override
    public String delete(Integer id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new BusinessException(PaymentMethodMessages.PAYMENTMETHOD_NOT_FOUND));
        paymentMethodRepository.delete(paymentMethod);

        return PaymentMethodMessages.PAYMENTMETHOD_DELETED;
    }

    @Override
    public List<PaymentMethod> getAll() {
        return paymentMethodRepository.findAll();

    }

    @Override
    public PaymentMethod getById(Integer id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new BusinessException(PaymentMethodMessages.PAYMENTMETHOD_NOT_FOUND));

        return paymentMethod;
    }
}