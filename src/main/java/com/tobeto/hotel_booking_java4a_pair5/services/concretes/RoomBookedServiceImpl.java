package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.*;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomBookedRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.*;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.*;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomBookedServiceImpl implements RoomBookedService {
    private final RoomBookedRepository roomBookedRepository;

    @Override
    public Result add(AddRoomBookedRequest request) {
        RoomBooked roomBooked = RoomBookedMapper.INSTANCE.roomBookedFromAddRequest(request);
        roomBooked = roomBookedRepository.save(roomBooked);

        return new SuccessResult(RoomBookedMessages.ROOMBOOKED_ADDED);
    }

    @Override
    public Result update(UpdateRoomBookedRequest request) {
        RoomBooked roomBooked = RoomBookedMapper.INSTANCE.roomBookedFromUpdateRequest(request);
        roomBooked = roomBookedRepository.save(roomBooked);

        return new SuccessResult(RoomBookedMessages.ROOMBOOKED_UPDATED);
    }

    @Override
    public Result delete(Integer id) {
        return null;
    }

    @Override
    public DataResult<List<GetAllRoomBookedResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<GetByIdRoomBookedResponse> getById(Integer id) {
        return null;
    }
}