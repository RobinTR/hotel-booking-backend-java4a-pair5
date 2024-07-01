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

import java.time.LocalDate;
import java.util.List;

@Table(name = "citizens")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Citizen extends BaseEntity {
    @Size(min = 2, max = 32, message = "First name must be between 2-32 characters.")
    @Column(name = "first_name")
    private String firstName;

    @Size(min = 2, max = 32, message = "Last name must be between 2-32 characters.")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "citizen")
    private List<CitizenOfBooking> citizenOfBookings;
}
