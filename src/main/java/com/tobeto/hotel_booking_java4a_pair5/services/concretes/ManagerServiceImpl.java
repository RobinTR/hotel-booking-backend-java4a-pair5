package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ManagerRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ManagerMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.ManagerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;

    @Override
    public Manager add(AddManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromAddRequest(request);
        manager = managerRepository.save(manager);

        return manager;
    }

    @Override
    public Manager update(UpdateManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromUpdateRequest(request);
        manager = managerRepository.save(manager);

        return manager;
    }

    @Override
    public String delete(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new BusinessException(ManagerMessages.MANAGER_NOT_FOUND));
        managerRepository.delete(manager);

        return ManagerMessages.MANAGER_DELETED;
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager getById(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new BusinessException(ManagerMessages.MANAGER_NOT_FOUND));

        return manager;
    }
}
