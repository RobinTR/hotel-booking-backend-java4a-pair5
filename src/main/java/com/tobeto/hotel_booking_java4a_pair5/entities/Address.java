package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "addresses")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "neighborhood_id")
    private Neighborhood neighborhood;

    @Size(min = 8, max = 255)
    @Column(name = "full_address")
    private String fullAddress;

    @OneToMany(mappedBy = "address")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "address")
    private List<User> users;
}
