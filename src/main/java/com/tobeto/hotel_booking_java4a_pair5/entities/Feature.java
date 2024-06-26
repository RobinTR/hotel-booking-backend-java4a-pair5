package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "features")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Feature extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "feature")
    private List<RoomTypeFeature> roomTypeFeatures;

    @OneToMany(mappedBy = "feature")
    private List<HotelFeature> hotelFeatures;
}
