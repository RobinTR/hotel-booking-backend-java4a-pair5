package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.entities.User;
import com.tobeto.hotel_booking_java4a_pair5.repositories.GuestRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.UserService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestForRegisterRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.GuestRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final UserService userService;
    private final GuestRules guestRules;

    @Override
    public Guest add(AddGuestForRegisterRequest request) {
        Guest guest = GuestMapper.INSTANCE.addGuestForRegisterRequestFromUser(request);
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
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new BusinessException(GuestMessages.GUEST_NOT_FOUND));
        guestRepository.delete(guest);

        return GuestMessages.GUEST_DELETED;
    }

    @Override
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getById(Integer id) {
        return guestRules.findById(id);
    }

    @Override
    public Integer getByUserId(Integer userId) {
        User user = userService.getById(userId);
        Guest guest = guestRepository.findByUser(user);

        return guest.getId();
    }
}
