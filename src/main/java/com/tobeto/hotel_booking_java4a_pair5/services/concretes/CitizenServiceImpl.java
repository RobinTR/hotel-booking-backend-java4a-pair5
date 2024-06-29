package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Citizen;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CitizenRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.AddCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizen.UpdateCitizenRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;

    @Override
    public Citizen add(AddCitizenRequest request) {
        Citizen citizen = CitizenMapper.INSTANCE.citizenFromAddRequest(request);

        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen update(UpdateCitizenRequest request) {
        Citizen citizen = CitizenMapper.INSTANCE.citizenFromUpdateRequest(request);

        return citizenRepository.save(citizen);
    }
}
