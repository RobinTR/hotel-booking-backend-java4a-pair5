package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingDateResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchByBookingDateHotelsResponse {
    private Integer id;
    private List<GetAllBookingDateResponse> booking;
    private String addressName;
    private String name;
    private String contactNumber;
    private String email;
    private String website;
    private String description;
    private int floorCount;
    private int starRating;
}
