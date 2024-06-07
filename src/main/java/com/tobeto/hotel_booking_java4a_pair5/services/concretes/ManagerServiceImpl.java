package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Manager;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ManagerRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.ManagerMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.ManagerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private ManagerRepository managerRepository;

    @Override
    public Result add(AddManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromAddRequest(request);
        manager = managerRepository.save(manager);

        return new SuccessResult(ManagerMessages.MANAGER_ADDED);
    }

    @Override
    public Result update(UpdateManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromUpdateRequest(request);
        manager = managerRepository.save(manager);

        return new SuccessResult(ManagerMessages.MANAGER_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException(ManagerMessages.MANAGER_NOT_FOUND));
        managerRepository.deleteById(manager.getId());

        return new SuccessResult(ManagerMessages.MANAGER_DELETED);
    }

    @Override
    public DataResult<List<GetAllManagerResponse>> getAll() {
        List<Manager> managers = managerRepository.findAll();
        List<GetAllManagerResponse> response = ManagerMapper.INSTANCE.getAllManagerResponseList(managers);

        return new SuccessDataResult<>(response, ManagerMessages.MANAGER_LISTED);
    }

    @Override
    public DataResult<GetByIdManagerResponse> getById(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException(ManagerMessages.MANAGER_NOT_FOUND));
        GetByIdManagerResponse response = ManagerMapper.INSTANCE.getByIdManagerResponse(manager);

        return new SuccessDataResult<>(response, ManagerMessages.MANAGER_LISTED);
    }
}
