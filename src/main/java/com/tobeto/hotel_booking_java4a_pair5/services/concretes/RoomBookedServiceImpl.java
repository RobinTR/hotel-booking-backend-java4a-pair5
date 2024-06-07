package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.core.result.DataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.Result;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessDataResult;
import com.tobeto.hotel_booking_java4a_pair5.core.result.SuccessResult;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomBookedRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetAllRoomBookedResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.GetByIdRoomBookedResponse;
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
        RoomBooked roomBooked = roomBookedRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomBookedMessages.ROOMBOOKED_NOT_FOUND));
        roomBookedRepository.delete(roomBooked);

        return new SuccessResult(RoomBookedMessages.ROOMBOOKED_DELETED);
    }

    @Override
    public DataResult<List<GetAllRoomBookedResponse>> getAll() {
        List<RoomBooked> roomBooked = roomBookedRepository.findAll();
        List<GetAllRoomBookedResponse> response = RoomBookedMapper.INSTANCE.getAllRoomBookedResponseListFromRoomBooked(roomBooked);

        return new SuccessDataResult<>(response, RoomBookedMessages.ROOMBOOKED_LISTED);
    }

    @Override
    public DataResult<GetByIdRoomBookedResponse> getById(Integer id) {
        RoomBooked roomBooked = roomBookedRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomBookedMessages.ROOMBOOKED_NOT_FOUND));
        GetByIdRoomBookedResponse getByIdRoomBookedResponse = RoomBookedMapper.INSTANCE.getByIdRoomBookedResponseFromRoomBooked(roomBooked);

        return new SuccessDataResult<>(getByIdRoomBookedResponse, RoomBookedMessages.ROOMBOOKED_LISTED);
    }
}
