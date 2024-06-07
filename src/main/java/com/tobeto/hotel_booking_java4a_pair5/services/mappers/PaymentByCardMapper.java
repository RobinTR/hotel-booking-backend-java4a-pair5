package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentByCard;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.AddPaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.paymentbycard.UpdatePaymentByCardRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetAllPaymentByCardResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentbycard.GetByIdPaymentByCardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentByCardMapper {
    PaymentByCardMapper INSTANCE = Mappers.getMapper(PaymentByCardMapper.class);

    @Mapping(target = "paymentMethod.id", source = "paymentMethodId")
    PaymentByCard paymentByCardFromAddRequest(AddPaymentByCardRequest request);

    @Mapping(target = "paymentMethod.id", source = "paymentMethodId")
    PaymentByCard paymentByCardFromUpdateRequest(UpdatePaymentByCardRequest request);

    @Mapping(target = "paymentMethodName", source = "paymentMethod.name")
    GetAllPaymentByCardResponse getAllPaymentByCardResponseMap(PaymentByCard paymentByCard);

    List<GetAllPaymentByCardResponse> getAllPaymentByCardResponseList(List<PaymentByCard> paymentByCards);

    @Mapping(target = "paymentMethodName", source = "paymentMethod.name")
    GetByIdPaymentByCardResponse getByIdPaymentByCardResponse(PaymentByCard paymentByCard);

}
