package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Citizen;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.UpdateCitizenRequest;

public interface CitizenService {
    Citizen add(AddCitizenRequest request);

    Citizen update(UpdateCitizenRequest request);
}
