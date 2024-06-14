package com.tobeto.hotel_booking_java4a_pair5.services.abstracts;

import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;

import java.util.List;

public interface ManagerService {
    Manager add(AddManagerRequest request);

    Manager update(UpdateManagerRequest request);

    String delete(Integer id);

    List<Manager> getAll();

    Manager getById(Integer id);
}
