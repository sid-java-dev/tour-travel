package com.airbnb.payload;

import com.airbnb.entity.Country;
import com.airbnb.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPropertyRequest {
    private String propertyName;
    private Integer bathrooms;
    private Integer noOfBed;
    private Integer nightlyPrice;
    private Integer guests;
    private Integer bedrooms;
    private Country country;
    private Location location;
}
