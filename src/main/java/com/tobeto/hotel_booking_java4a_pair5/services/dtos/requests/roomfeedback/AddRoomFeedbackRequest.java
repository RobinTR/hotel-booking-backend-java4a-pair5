package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomFeedbackRequest {
    private Integer bookingId;
    private boolean isAnswered;
    private int starRating;
    private String description;
    private String managerFeedback;
}
