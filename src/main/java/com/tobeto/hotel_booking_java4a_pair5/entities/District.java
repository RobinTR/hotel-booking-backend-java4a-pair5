package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "districts")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class District extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "district")
    private List<Address> addresses;

    @OneToMany(mappedBy = "district")
    private List<Area> areas;
}
