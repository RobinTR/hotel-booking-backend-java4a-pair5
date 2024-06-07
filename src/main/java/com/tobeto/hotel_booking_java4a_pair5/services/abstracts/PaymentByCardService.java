package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;

import java.util.List;

public interface PaymentByCardService {
    Result add(AddPaymentByCardRequest request);

    Result update(UpdatePaymentByCardRequest request);

    Result delete(Integer id);

    DataResult<List<GetAllPaymentByCardResponse>> getAll();

    DataResult<GetByIdPaymentByCardResponse> getById(Integer id);
}
