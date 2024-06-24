package com.airbnb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "property_image")
public class PropertyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "property_image", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] propertyImage;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}