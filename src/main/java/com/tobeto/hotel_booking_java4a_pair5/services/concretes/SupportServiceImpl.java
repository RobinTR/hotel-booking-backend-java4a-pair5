package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Support;
import com.tobeto.hotel_booking_java4a_pair5.repositories.SupportRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.SupportService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.SupportMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.AddSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.support.UpdateSupportRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.SupportMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.SupportRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportServiceImpl implements SupportService {
    private final SupportRepository supportRepository;
    private final SupportRules supportRules;

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
        Support support = supportRules.findById(id);
        supportRepository.delete(support);

        return SupportMessages.SUPPORT_DELETED;
    }

    @Override
    public List<Support> getAll() {
        return supportRepository.findAll();
    }

    @Override
    public Support getById(Integer id) {
        return supportRules.findById(id);
    }
}
