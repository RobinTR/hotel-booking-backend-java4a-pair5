package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking;

import com.tobeto.hotel_booking_java4a_pair5.entities.PaymentStatus;
import com.tobeto.hotel_booking_java4a_pair5.entities.ReservationStatus;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.citizenofbooking.GetCitizenOfBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.guest.GuestDtoForBooking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel.HotelDtoForBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.paymentmethod.GetByIdPaymentMethodResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked.RoomBookedDtoForBookingResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GetBookingByManagerIdResponse {
    private Integer id;
    private HotelDtoForBookingResponse hotel;
    private GuestDtoForBooking guest;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private ReservationStatus reservationStatus;
    private List<RoomBookedDtoForBookingResponse> roomBooked;
}
