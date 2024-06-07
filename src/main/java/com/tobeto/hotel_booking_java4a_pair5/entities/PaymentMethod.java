package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "payment_methods")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod extends BaseEntity {
    @Size(min = 8, max = 128, message = "Payment method name must be between 8-128 characters.")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "paymentMethod")
    private List<PaymentByCard> paymentByCards;
}
