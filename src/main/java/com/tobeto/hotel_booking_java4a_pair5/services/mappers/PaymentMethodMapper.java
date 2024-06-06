package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentMethod;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.AddPaymentMethodRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentmethod.UpdatePaymentMethodRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMethodMapper {


    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethod paymentMethodFromAddRequest(AddPaymentMethodRequest request);

    PaymentMethod paymentMethodFromUpdateRequest(UpdatePaymentMethodRequest request);
}
