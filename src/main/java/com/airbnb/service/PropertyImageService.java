package com.airbnb.service;

import com.airbnb.entity.Property;
import com.airbnb.entity.PropertyImage;
import com.airbnb.repository.PropertyImageRepository;
import com.airbnb.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyImageService {
    private PropertyImageRepository imageRepository;
    private PropertyRepository propertyRepository;

    public PropertyImageService(PropertyImageRepository imageRepository, PropertyRepository propertyRepository) {
        this.imageRepository = imageRepository;
        this.propertyRepository = propertyRepository;
    }

    public PropertyImage addPhoto(byte[] image, long propertyId) {
        Optional<Property> byId = propertyRepository.findById(propertyId);
        if (byId.isPresent()) {
            Property property = byId.get();
            PropertyImage photo = new PropertyImage();
            photo.setPropertyImage(image);
            photo.setProperty(property);
            return imageRepository.save(photo);
        }
        return null;
    }
}
