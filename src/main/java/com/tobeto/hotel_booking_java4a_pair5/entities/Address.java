package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
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
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "full_address")
    private String fullAddress;

    @OneToMany(mappedBy = "address")
    private List<Hotel> hotels;

    @OneToMany(mappedBy = "address")
    private List<Person> persons;
}
