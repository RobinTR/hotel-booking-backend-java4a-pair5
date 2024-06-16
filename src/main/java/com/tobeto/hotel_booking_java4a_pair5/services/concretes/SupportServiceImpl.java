package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.repositories.SupportRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.SupportMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupportServiceImpl implements SupportService {
    private final SupportRepository supportRepository;

    @Override
    public Support add(AddSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromAddRequest(request);
        support = supportRepository.save(support);

        return support;
    }

    @Override
    public Support update(UpdateSupportRequest request) {
        Support support = SupportMapper.INSTANCE.supportFromUpdateRequest(request);
        support = supportRepository.save(support);

        return support;
    }

    @Override
    public String delete(Integer id) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new BusinessException(SupportMessages.SUPPORT_NOT_FOUND));
        supportRepository.delete(support);

        return SupportMessages.SUPPORT_DELETED;
    }

    @Override
    public List<Support> getAll() {
        return supportRepository.findAll();
    }

    @Override
    public Support getById(Integer id) {
        Support support = supportRepository.findById(id).orElseThrow(() -> new BusinessException(SupportMessages.SUPPORT_NOT_FOUND));

        return support;
    }
}
