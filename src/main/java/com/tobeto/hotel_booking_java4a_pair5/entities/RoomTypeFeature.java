package com.tobeto.hotel_booking_java4a_pair5.entities;

import com.tobeto.hotel_booking_java4a_pair5.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "room_types_features")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeFeature extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @Column(name = "is_available", columnDefinition = "boolean default false")
    private boolean isAvailable;
}
