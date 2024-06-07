package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetAllSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetByIdSupportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SupportMapper {
    SupportMapper INSTANCE = Mappers.getMapper(SupportMapper.class);

    Support supportFromAddRequest(AddSupportRequest addSupportRequest);

    Support supportFromUpdateRequest(UpdateSupportRequest updateSupportRequest);

    GetAllSupportResponse getAllSupportResponseMap(Support support);

    List<GetAllSupportResponse> getAllSupportResponseListFromSupports(List<Support> supports);

    GetByIdSupportResponse getByIdSupportResponseFromSupport(Support support);
}
