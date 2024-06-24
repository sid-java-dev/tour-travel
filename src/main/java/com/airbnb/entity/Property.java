package com.airbnb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bathrooms", nullable = false)
    private Integer bathrooms;

    @Column(name = "property_name", nullable = false, length = 150)
    private String propertyName;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "no_of_bed", nullable = false)
    private Integer noOfBed;

    @Column(name = "nightly_price", nullable = false)
    private Integer nightlyPrice;

    @Column(name = "guests", nullable = false)
    private Integer guests;

    @Column(name = "bedrooms", nullable = false)
    private Integer bedrooms;

}