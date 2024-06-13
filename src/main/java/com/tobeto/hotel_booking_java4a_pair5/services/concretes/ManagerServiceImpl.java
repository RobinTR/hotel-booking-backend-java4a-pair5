package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromAddRequest(request);
        manager = managerRepository.save(manager);

        return new SuccessResponse(ManagerMessages.MANAGER_ADDED);
    }

    @Override
    public Response update(UpdateManagerRequest request) {
        Manager manager = ManagerMapper.INSTANCE.managerFromUpdateRequest(request);
        manager = managerRepository.save(manager);

        return new SuccessResponse(ManagerMessages.MANAGER_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException(ManagerMessages.MANAGER_NOT_FOUND));
        managerRepository.deleteById(manager.getId());

        return new SuccessResponse(ManagerMessages.MANAGER_DELETED);
    }

    @Override
    public DataResponse<List<GetAllManagerResponse>> getAll() {
        List<Manager> managers = managerRepository.findAll();
        List<GetAllManagerResponse> response = ManagerMapper.INSTANCE.getAllManagerResponseList(managers);

        return new SuccessDataResponse<>(response, ManagerMessages.MANAGER_LISTED);
    }

    @Override
    public DataResponse<GetByIdManagerResponse> getById(Integer id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new RuntimeException(ManagerMessages.MANAGER_NOT_FOUND));
        GetByIdManagerResponse response = ManagerMapper.INSTANCE.getByIdManagerResponse(manager);

        return new SuccessDataResponse<>(response, ManagerMessages.MANAGER_LISTED);
    }
}
