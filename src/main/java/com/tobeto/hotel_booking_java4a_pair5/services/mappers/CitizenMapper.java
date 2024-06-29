package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.Citizen;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.UpdateCitizenRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CitizenMapper {
    CitizenMapper INSTANCE = Mappers.getMapper(CitizenMapper.class);

    AddCitizenRequest addRequestFromCitizen(Citizen citizen);

    UpdateCitizenRequest updateRequestFromCitizen(Citizen citizen);

    Citizen citizenFromAddRequest(AddCitizenRequest addCitizenRequest);

    Citizen citizenFromUpdateRequest(UpdateCitizenRequest updateCitizenRequest);
}
