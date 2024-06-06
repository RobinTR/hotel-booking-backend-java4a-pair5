package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.*;
import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.repositories.SupportRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.*;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.SupportMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupportServiceImpl implements SupportService {
    private final SupportRepository supportRepository;

    @Override
    public Result add(AddSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromAddRequest(request);
        support = supportRepository.save(support);

        return new SuccessResult(SupportMessages.SUPPORT_ADDED);
    }

    @Override
    public Result update(UpdateSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromUpdateRequest(request);
        support = supportRepository.save(support);

        return new SuccessResult(SupportMessages.SUPPORT_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllSupportResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdSupportResponse> getById(Integer id) {
        return null;
    }
}
