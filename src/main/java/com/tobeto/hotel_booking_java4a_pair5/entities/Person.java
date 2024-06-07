package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "persons")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Size(min = 2, max = 32, message = "First name must be between 2-32 characters.")
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 2, max = 32, message = "Last name must be between 2-32 characters.")
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 128, message = "Email must be maximum 128 characters.")
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Size(min = 8, max = 32, message = "Password must be between 8-32 characters.")
    @Column(name = "password")
    private String password;
}
