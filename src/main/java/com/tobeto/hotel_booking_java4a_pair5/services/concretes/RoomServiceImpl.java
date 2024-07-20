package com.tobeto.hotel_booking_java4a_pair5.services.concretes;

import com.tobeto.hotel_booking_java4a_pair5.entities.Hotel;
import com.tobeto.hotel_booking_java4a_pair5.entities.Room;
import com.tobeto.hotel_booking_java4a_pair5.entities.RoomType;
import com.tobeto.hotel_booking_java4a_pair5.repositories.RoomRepository;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.HotelService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomService;
import com.tobeto.hotel_booking_java4a_pair5.services.abstracts.RoomTypeService;
import com.tobeto.hotel_booking_java4a_pair5.services.constants.RoomMessages;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.AddRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room.UpdateRoomRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.mappers.RoomMapper;
import com.tobeto.hotel_booking_java4a_pair5.services.rules.RoomRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final HotelService hotelService;
    private final RoomTypeService roomTypeService;
    private final RoomRules roomRules;

    @Override
    public Room add(AddRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromAddRequest(request);
        RoomType roomType = roomTypeService.getById(request.getRoomTypeId());
        room.setRoomType(roomType);
        room = roomRepository.save(room);

        return room;
    }

    @Override
    public Room update(UpdateRoomRequest request) {
        Room room = RoomMapper.INSTANCE.roomFromUpdateRequest(request);
        Hotel hotel = hotelService.getById(request.getHotelId());
        room.setHotel(hotel);

        RoomType roomType = roomTypeService.getById(request.getRoomTypeId());
        room.setRoomType(roomType);
        room = roomRepository.save(room);

        return room;
    }

    @Override
    public String delete(Integer id) {
        Room room = roomRules.findById(id);
        roomRepository.delete(room);

        return RoomMessages.ROOM_DELETED;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room getById(Integer id) {
        return roomRules.findById(id);
    }
}
