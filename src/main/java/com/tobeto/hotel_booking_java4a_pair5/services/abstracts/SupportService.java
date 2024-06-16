package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;

import java.util.List;

public interface SupportService {
    Support add(AddSupportRequest request);

    Support update(UpdateSupportRequest request);

    String delete(Integer id);

    List<Support> getAll();

    Support getById(Integer id);
}
