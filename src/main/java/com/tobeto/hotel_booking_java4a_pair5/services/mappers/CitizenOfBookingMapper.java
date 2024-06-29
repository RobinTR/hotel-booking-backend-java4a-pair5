package com.tobeto.hotel_booking_java4a_pair5.services.mappers;

import com.tobeto.hotel_booking_java4a_pair5.entities.CitizenOfBooking;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.AddCitizenOfBookingRequest;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.citizenofbooking.UpdateCitizenOfBookingRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CitizenOfBookingMapper {
    CitizenOfBookingMapper INSTANCE = Mappers.getMapper(CitizenOfBookingMapper.class);

    @Mapping(target = "citizenId", source = "citizen.id")
    @Mapping(target = "bookingId", source = "booking.id")
    AddCitizenOfBookingRequest addRequestFromCitizen(CitizenOfBooking citizenOfBooking);

    @Mapping(target = "citizenId", source = "citizen.id")
    @Mapping(target = "bookingId", source = "booking.id")
    UpdateCitizenOfBookingRequest updateRequestFromCitizen(CitizenOfBooking citizenOfBooking);

    @Mapping(target = "citizen.id", source = "citizenId")
    @Mapping(target = "booking.id", source = "bookingId")
    CitizenOfBooking citizenOfBookingFromAddRequest(AddCitizenOfBookingRequest addCitizenOfBookingRequest);

    @Mapping(target = "citizen.id", source = "citizenId")
    @Mapping(target = "booking.id", source = "bookingId")
    CitizenOfBooking citizenOfBookingFromUpdateRequest(UpdateCitizenOfBookingRequest updateCitizenOfBookingRequest);
}