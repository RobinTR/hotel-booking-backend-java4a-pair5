package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomBooked;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomBookedRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomBookedService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomBookedMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.AddRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked.UpdateRoomBookedRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomBookedMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.RoomBookedRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomBookedServiceImpl implements RoomBookedService {
    private final RoomBookedRepository roomBookedRepository;
    private final RoomBookedRules roomBookedRules;

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
        RoomBooked roomBooked = roomBookedRules.findById(id);
        roomBookedRepository.delete(roomBooked);

        return RoomBookedMessages.ROOM_BOOKED_DELETED;
    }

    @Override
    public List<RoomBooked> getAll() {
        return roomBookedRepository.findAll();
    }

    @Override
    public RoomBooked getById(Integer id) {
        return roomBookedRules.findById(id);
    }

    @Override
    public List<RoomBooked> findByBooking(Booking booking) {
        return roomBookedRepository.findByBooking(booking);
    }
}
