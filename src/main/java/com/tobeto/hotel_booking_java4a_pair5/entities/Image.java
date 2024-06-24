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

@Table(name = "images")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image extends BaseEntity {
    @Column(name = "url")
    private String url;

    @Column(name = "public_id")
    private String publicId;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @OneToMany(mappedBy = "image")
    private List<HotelImage> hotelImages;

    @OneToMany(mappedBy = "image")
    private List<RoomImage> roomImages;
}
