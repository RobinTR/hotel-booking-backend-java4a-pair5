package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomFeedbackRequest {
    @NotNull(message = "You must enter an id.")
    private Integer id;
    @NotNull(message = "You must enter a booking id.")
    private Integer bookingId;
    private boolean isAnswered;
    @Size(min = 1, max = 5)
    private int starRating;
    private String description;
    private String managerFeedback;
}
