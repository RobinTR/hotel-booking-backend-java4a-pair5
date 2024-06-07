package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomFeedbackRequest {
    @NotNull(message = "You must enter a booking id.")
    private Integer bookingId;

    private boolean isAnswered;

    @Min(1)
    @Max(5)
    private int starRating;

    private String description;

    private String managerFeedback;
}
