package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "payment_by_cards")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PaymentByCard extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "card_number")
    @Size(max=4)
    private String cardNumber;

    @Column(name = "card_expiration_date")
    private String cardExpirationDate;

    @Column(name = "cvv")
    private String cvv;

    @OneToMany(mappedBy = "paymentByCard")
    private List<Guest> guests;
}
