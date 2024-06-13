package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.repositories.SupportRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetAllSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.support.GetByIdSupportResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.SupportMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupportServiceImpl implements SupportService {
    private final SupportRepository supportRepository;

    @Override
    public Response add(AddSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromAddRequest(request);
        support = supportRepository.save(support);

        return new SuccessResponse(SupportMessages.SUPPORT_ADDED);
    }

    @Override
    public Response update(UpdateSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromUpdateRequest(request);
        support = supportRepository.save(support);

        return new SuccessResponse(SupportMessages.SUPPORT_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new RuntimeException(SupportMessages.SUPPORT_NOT_FOUND));
        supportRepository.delete(support);

        return new SuccessResponse(SupportMessages.SUPPORT_DELETED);
    }

    @Override
    public DataResponse<List<GetAllSupportResponse>> getAll() {
        List<Support> supports = supportRepository.findAll();
        List<GetAllSupportResponse> response = SupportMapper.INSTANCE.getAllSupportResponseListFromSupports(supports);

        return new SuccessDataResponse<>(response, SupportMessages.SUPPORT_LISTED);
    }

    @Override
    public DataResponse<GetByIdSupportResponse> getById(Integer id) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new RuntimeException(SupportMessages.SUPPORT_NOT_FOUND));
        GetByIdSupportResponse response = SupportMapper.INSTANCE.getByIdSupportResponseFromSupport(support);

        return new SuccessDataResponse<>(response, SupportMessages.SUPPORT_LISTED);
    }
}
