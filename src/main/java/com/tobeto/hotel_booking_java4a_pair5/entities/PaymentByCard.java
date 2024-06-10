package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Card number cannot be blank.")
    @Size(max = 19, message = "Card number  must be maximum 19 characters")
    @Column(name = "card_number")
    private String cardNumber;

    @NotBlank(message = "Card expiration month cannot be blank.")
    @Size(min = 2, max = 2, message = "Card expiration month must be 2 characters")
    @Column(name = "expiration_month")
    private String expirationMonth;

    @NotBlank(message = "Card expiration year cannot be blank.")
    @Size(min = 2, max = 2, message = "Card expiration year must be 2 characters")
    @Column(name = "expiration_year")
    private String expirationYear;

    @NotBlank(message = "CVV cannot be blank.")
    @Column(name = "cvv")
    @Size(max = 4, message = "Cvv must be maximum 4 characters")
    private String cvv;

    @OneToMany(mappedBy = "paymentByCard")
    private List<User> users;
}
