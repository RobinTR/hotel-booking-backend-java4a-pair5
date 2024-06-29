package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.CitizenOfBooking;
import com.tobeto.hotel_booking_java4a_pair5.repositories.CitizenOfBookingRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.CitizenOfBookingService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.UpdateCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.CitizenOfBookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitizenOfBookingServiceImpl implements CitizenOfBookingService {
    private final CitizenOfBookingRepository citizenOfBookingRepository;

    @Override
    public CitizenOfBooking add(AddCitizenOfBookingRequest request) {
        CitizenOfBooking citizenOfBooking = CitizenOfBookingMapper.INSTANCE.citizenOfBookingFromAddRequest(request);

        return citizenOfBookingRepository.save(citizenOfBooking);
    }

    @Override
    public CitizenOfBooking update(UpdateCitizenOfBookingRequest request) {
        CitizenOfBooking citizenOfBooking = CitizenOfBookingMapper.INSTANCE.citizenOfBookingFromUpdateRequest(request);

        return citizenOfBookingRepository.save(citizenOfBooking);
    }
}
