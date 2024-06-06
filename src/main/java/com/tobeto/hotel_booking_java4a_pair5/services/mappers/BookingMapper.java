package com.tobeto.hotel_booking_java4a_pair5.services.mappers;


import com.tobeto.hotel_booking_java4a_pair5.entities.Booking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.AddBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.booking.UpdateBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "guest.id", source = "guestId")
    Booking bookingFromAddRequest(AddBookingRequest request);

    @Mapping(target = "hotel.id", source = "hotelId")
    @Mapping(target = "guest.id", source = "guestId")
    Booking bookingFromUpdateRequest(UpdateBookingRequest request);
}
