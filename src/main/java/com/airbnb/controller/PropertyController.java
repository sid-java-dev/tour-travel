package com.airbnb.controller;

import com.airbnb.entity.Property;
import com.airbnb.payload.AddPropertyRequest;
import com.airbnb.repository.PropertyRepository;
import com.airbnb.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/properties")
public class PropertyController {
    private PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
            this.propertyService = propertyService;

    }
    @PostMapping("/addWithCountryAndLocation")
    public ResponseEntity<String> addPropertyWithCountryAndLocation(@RequestBody AddPropertyRequest request) {
       propertyService.addPropertyWithCountryAndLocation(request);
        return ResponseEntity.ok("property added successfully");
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<Property>> getPropertyByLocation(@PathVariable String location) {
        List<Property> properties = propertyService.getPropertyByLocation(location);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

}
