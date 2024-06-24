package com.airbnb.controller;

import com.airbnb.entity.PropertyImage;
import com.airbnb.service.PropertyImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/images")
public class PropertyImageController {
private PropertyImageService imageService;

    public PropertyImageController(PropertyImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add/{propertyId}")
    public ResponseEntity<?>addPropertyImage(@RequestParam("propertyImage")MultipartFile propertyImage, @PathVariable long propertyId){

        try {
            if (!propertyImage.getContentType().equals("application/pdf")) {
                return new ResponseEntity<>("Only PDF files are allowed.", HttpStatus.BAD_REQUEST);

            }
            PropertyImage addPhoto = imageService.addPhoto(propertyImage.getBytes(), propertyId);
            return new ResponseEntity<>(addPhoto, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Error ",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
