package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import com.tobeto.hotel_booking_java4a_pair5.repositories.GuestRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.GuestService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.GuestMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.AddGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest.UpdateGuestRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetAllGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GetByIdGuestResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.GuestMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {
    private GuestRepository guestRepository;

    @Override
    public Result add(AddGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromAddRequest(request);
        guest = guestRepository.save(guest);

        return new SuccessResult(GuestMessages.GUEST_ADDED);
    }

    @Override
    public Result update(UpdateGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromUpdateRequest(request);
        guest = guestRepository.save(guest);

        return new SuccessResult(GuestMessages.GUEST_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllGuestResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdGuestResponse> getById(Integer id) {
        return null;
    }
}
