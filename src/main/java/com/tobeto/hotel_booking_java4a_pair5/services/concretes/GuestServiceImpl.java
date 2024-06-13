package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.DataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.Response;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessDataResponse;
import com.tobeto.hotel_booking_java4a_pair5.core.services.dtos.responses.SuccessResponse;
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
    public Response add(AddGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromAddRequest(request);
        guest = guestRepository.save(guest);

        return new SuccessResponse(GuestMessages.GUEST_ADDED);
    }

    @Override
    public Response update(UpdateGuestRequest request) {
        Guest guest = GuestMapper.INSTANCE.guestFromUpdateRequest(request);
        guest = guestRepository.save(guest);

        return new SuccessResponse(GuestMessages.GUEST_UPDATED);
    }

    @Override
    public Response delete(Integer id) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException(GuestMessages.GUEST_DELETED));
        guestRepository.deleteById(guest.getId());

        return new SuccessResponse(GuestMessages.GUEST_DELETED);
    }

    @Override
    public DataResponse<List<GetAllGuestResponse>> getAll() {
        List<Guest> guests = guestRepository.findAll();
        List<GetAllGuestResponse> response = GuestMapper.INSTANCE.getAllGuestResponseList(guests);

        return new SuccessDataResponse<>(response, GuestMessages.GUEST_LISTED);
    }

    @Override
    public DataResponse<GetByIdGuestResponse> getById(Integer id) {
        Guest guest = guestRepository.findById(id).orElseThrow(() -> new RuntimeException(GuestMessages.GUEST_NOT_FOUND));
        GetByIdGuestResponse response = GuestMapper.INSTANCE.getByIdGuestResponse(guest);

        return new SuccessDataResponse<>(response, GuestMessages.GUEST_LISTED);
    }
}
