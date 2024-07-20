package com.tobeto.hotel_booking_java4a_pair5.services.rules;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.ResourceNotFoundException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ManagerRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ManagerMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerRules {
    private final ManagerRepository managerRepository;

    public Manager findById(Integer id) {
        return managerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ManagerMessages.MANAGER_NOT_FOUND));
    }
}
