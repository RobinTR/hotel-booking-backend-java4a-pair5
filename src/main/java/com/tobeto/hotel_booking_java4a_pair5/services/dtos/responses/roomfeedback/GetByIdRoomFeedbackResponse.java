package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeedback;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdRoomFeedbackResponse {
    private Integer id;
    private String bookingHotelName;
    private boolean isAnswered;
    private int starRating;
    private String description;
    private String managerFeedback;
}
