package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetAllPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetByIdPaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
    Result add(AddPaymentMethodRequest request);
    Result update(UpdatePaymentMethodRequest request);
    Result delete(Integer id);
    DataResult<List<GetAllPaymentMethodResponse>> getAll();
    DataResult<GetByIdPaymentMethodResponse> getById(Integer id);
}
