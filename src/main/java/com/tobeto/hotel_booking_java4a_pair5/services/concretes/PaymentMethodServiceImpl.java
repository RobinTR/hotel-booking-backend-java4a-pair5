package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddPaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromAddRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_ADDED);
    }

    @Override
    public Response update(UpdatePaymentMethodRequest request) {
        PaymentMethod paymentMethod = PaymentMethodMapper.INSTANCE.paymentMethodFromUpdateRequest(request);
        paymentMethod = paymentMethodRepository.save(paymentMethod);

        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentMethodMessages.PAYMENTMETHOD_NOT_FOUND));
        paymentMethodRepository.delete(paymentMethod);

        return new SuccessResponse(PaymentMethodMessages.PAYMENTMETHOD_DELETED);
    }

    @Override
    public DataResponse<List<GetAllPaymentMethodResponse>> getAll() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        List<GetAllPaymentMethodResponse> response = PaymentMethodMapper.INSTANCE.getAllPaymentMethodResponseList(paymentMethods);

        return new SuccessDataResponse<>(response, PaymentMethodMessages.PAYMENTMETHOD_LISTED);
    }

    @Override
    public DataResponse<GetByIdPaymentMethodResponse> getById(Integer id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() -> new RuntimeException(PaymentMethodMessages.PAYMENTMETHOD_NOT_FOUND));
        GetByIdPaymentMethodResponse response = PaymentMethodMapper.INSTANCE.getByIdPaymentMethodResponse(paymentMethod);

        return new SuccessDataResponse<>(response, PaymentMethodMessages.PAYMENTMETHOD_LISTED);
    }
}