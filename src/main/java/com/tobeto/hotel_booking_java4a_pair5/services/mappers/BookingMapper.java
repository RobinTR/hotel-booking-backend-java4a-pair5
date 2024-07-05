package com.tobeto.hotel_booking_java4a_pair5.services.mappers;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingDateResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetAllBookingResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetBookingByUserIdResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.booking.GetByIdBookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "guest.id", source = "guestId")
    @Mapping(target = "paymentMethod.id", source = "paymentMethodId")
    Booking bookingFromAddRequest(AddBookingRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "guest.id", source = "guestId")
    @Mapping(target = "paymentMethod.id", source = "paymentMethodId")
    Booking bookingFromUpdateRequest(UpdateBookingRequest request);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "guestName", expression = "java(booking.getGuest().getUser().getFirstName() + \"\" + booking.getGuest().getUser().getLastName())")
    @Mapping(target = "paymentMethodName", source = "paymentMethod.name")
    GetAllBookingResponse getAllBookingResponseMap(Booking booking);

    List<GetAllBookingResponse> getAllBookingResponseListFromBookings(List<Booking> bookings);

    @Mapping(target = "hotelName", source = "hotel.name")
    @Mapping(target = "guestName", expression = "java(booking.getGuest().getUser().getFirstName() + \"\" + booking.getGuest().getUser().getLastName())")
    @Mapping(target = "paymentMethodName", source = "paymentMethod.name")
    GetByIdBookingResponse getByIdBookingResponse(Booking booking);

    @Mapping(target = "hotelId", source = "hotel.id")
    GetAllBookingDateResponse getAllBookingDateResponseMap(Booking booking);

    List<GetAllBookingDateResponse> getAllBookingDateResponseListFromBookings(List<Booking> bookings);

    GetBookingByUserIdResponse getBookingByUserIdResponseMap(Booking booking);

    List<GetBookingByUserIdResponse> getBookingByUserIdResponseListFromBookings(List<Booking> bookings);
}
