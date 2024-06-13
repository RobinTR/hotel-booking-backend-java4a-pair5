package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomBookedRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomBookedServiceImpl implements RoomBookedService {
    private final RoomBookedRepository roomBookedRepository;

    @Override
    public RoomBooked add(AddRoomBookedRequest request) {
        RoomBooked roomBooked = RoomBookedMapper.INSTANCE.roomBookedFromAddRequest(request);
        roomBooked = roomBookedRepository.save(roomBooked);

        return roomBooked;
    }

    @Override
    public RoomBooked update(UpdateRoomBookedRequest request) {
        RoomBooked roomBooked = RoomBookedMapper.INSTANCE.roomBookedFromUpdateRequest(request);
        roomBooked = roomBookedRepository.save(roomBooked);

        return roomBooked;
    }

    @Override
    public String delete(Integer id) {
        RoomBooked roomBooked = roomBookedRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomBookedMessages.ROOMBOOKED_NOT_FOUND));
        roomBookedRepository.delete(roomBooked);

        return RoomBookedMessages.ROOMBOOKED_DELETED;
    }

    @Override
    public List<RoomBooked> getAll() {
        return roomBookedRepository.findAll();
    }

    @Override
    public RoomBooked getById(Integer id) {
        RoomBooked roomBooked = roomBookedRepository.findById(id).orElseThrow(() -> new RuntimeException(RoomBookedMessages.ROOMBOOKED_NOT_FOUND));

        return roomBooked;
    }

    @Override
    public List<RoomBooked> findByBooking(Booking booking) {
        List<RoomBooked> roomBooked = roomBookedRepository.findByBooking(booking);

        return roomBooked;
    }
}
