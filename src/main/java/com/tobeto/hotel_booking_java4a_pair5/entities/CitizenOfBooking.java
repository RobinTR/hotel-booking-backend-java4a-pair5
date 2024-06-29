package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "citizens_of_bookings")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CitizenOfBooking extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
