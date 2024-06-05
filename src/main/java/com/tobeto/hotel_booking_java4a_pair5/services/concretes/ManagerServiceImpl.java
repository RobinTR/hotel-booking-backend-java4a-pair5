package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.repositories.ManagerRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.ManagerService;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.AddManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager.UpdateManagerRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetAllManagerResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager.GetByIdManagerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private ManagerRepository managerRepository;

    @Override
    public Result add(AddManagerRequest request) {
        return null;
    }

    @Override
    public Result update(UpdateManagerRequest request) {
        return null;
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllManagerResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdManagerResponse> getById(Integer id) {
        return null;
    }
}
