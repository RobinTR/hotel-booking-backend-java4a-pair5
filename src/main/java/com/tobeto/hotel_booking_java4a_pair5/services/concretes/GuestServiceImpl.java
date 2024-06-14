package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.repositories.GuestRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;

    @Override
    public Guest add(AddGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromAddRequest(request);
        guest = guestRepository.save(guest);

        return guest;
    }

    @Override
    public Guest update(UpdateGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromUpdateRequest(request);
        guest = guestRepository.save(guest);

        return guest;
    }

    @Override
    public String delete(Integer id) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new BusinessException(GuestMessages.GUEST_DELETED));
        guestRepository.delete(guest);

        return GuestMessages.GUEST_DELETED;
    }

    @Override
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getById(Integer id) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new BusinessException(GuestMessages.GUEST_NOT_FOUND));

        return guest;
    }
}
