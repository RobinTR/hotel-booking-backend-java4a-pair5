package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestForRegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;

import java.util.List;

public interface GuestService {
    Guest add(AddGuestForRegisterRequest request);

    Guest update(UpdateGuestRequest request);

    String delete(Integer id);

    List<Guest> getAll();

    Guest getById(Integer id);

    Integer getByUserId(Integer userId);
}
