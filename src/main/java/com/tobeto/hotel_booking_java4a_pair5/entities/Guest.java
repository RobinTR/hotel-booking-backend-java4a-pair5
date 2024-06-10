package com.tobeto.hotel_booking_java4a_pair5.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "guests")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Guest extends User {
    @ManyToOne
    @JoinColumn(name = "payment_by_card_id")
    private PaymentByCard paymentByCard;

    @OneToMany(mappedBy = "guest")
    private List<Booking> bookings;
}
