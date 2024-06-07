package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.RoomFeedback;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.AddRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback.UpdateRoomFeedbackRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetAllRoomFeedbackResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback.GetByIdRoomFeedbackResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomFeedbackMapper {
    RoomFeedbackMapper INSTANCE = Mappers.getMapper(RoomFeedbackMapper.class);

    @Mapping(target = "booking.id", source = "bookingId")
    RoomFeedback roomFeedbackFromAddRequest(AddRoomFeedbackRequest request);

    @Mapping(target = "booking.id", source = "bookingId")
    RoomFeedback roomFeedbackFromUpdateRequest(UpdateRoomFeedbackRequest request);

    @Mapping(target = "bookingHotelName", source = "booking.hotel.name")
    GetAllRoomFeedbackResponse getAllRoomFeedbackResponseMap(RoomFeedback roomFeedback);

    List<GetAllRoomFeedbackResponse> getAllRoomFeedbackResponseListFromRoomFeedbacks(List<RoomFeedback> roomFeedbacks);

    @Mapping(target = "bookingHotelName", source = "booking.hotel.name")
    GetByIdRoomFeedbackResponse getByIdRoomFeedbackResponseFromRoomFeedback(RoomFeedback roomFeedback);
}
