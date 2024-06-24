package com.airbnb.service;

import com.airbnb.entity.Country;
import com.airbnb.entity.Location;
import com.airbnb.entity.Property;
import com.airbnb.payload.AddPropertyRequest;
import com.airbnb.repository.CountryRepository;
import com.airbnb.repository.LocationRepository;
import com.airbnb.repository.PropertyRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private CountryRepository countryRepository;
    private LocationRepository locationRepository;
    private PropertyRepository propertyRepository;

    public PropertyService(CountryRepository countryRepository, LocationRepository locationRepository, PropertyRepository propertyRepository) {
        this.countryRepository = countryRepository;
        this.locationRepository = locationRepository;
        this.propertyRepository = propertyRepository;
    }

    public void addPropertyWithCountryAndLocation(AddPropertyRequest request) {
        Country country=new Country();
        country.setCountryName(request.getCountry().getCountryName());
        Country saveCountry = countryRepository.save(country);
        Location location=new Location();
        location.setLocationName(request.getLocation().getLocationName());
        Location saveLocation = locationRepository.save(location);

        Property property=new Property();
        property.setPropertyName(request.getPropertyName());
        property.setBathrooms(request.getBathrooms());
        property.setNoOfBed(request.getNoOfBed());
        property.setNightlyPrice(request.getNightlyPrice());
        property.setGuests(request.getGuests());
        property.setBedrooms(request.getBedrooms());
        property.setCountry(saveCountry);
        property.setLocation(saveLocation);
        propertyRepository.save(property);


    }

    public List<Property> getPropertyByLocation(String location) {
        List<Property> properties = propertyRepository.findPropertyByLocation(location);
        return properties;
    }
}
