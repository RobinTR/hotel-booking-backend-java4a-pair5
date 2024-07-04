package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.CitizenOfBooking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.UpdateCitizenOfBookingRequest;

public interface CitizenOfBookingService {
    CitizenOfBooking add(AddCitizenOfBookingRequest request);

    CitizenOfBooking update(UpdateCitizenOfBookingRequest request);
}
