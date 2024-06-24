package com.airbnb.service;

import com.airbnb.entity.Property;
import com.airbnb.entity.Review;
import com.airbnb.exception.ResourceNotFoundException;
import com.airbnb.repository.PropertyRepository;
import com.airbnb.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private PropertyRepository propertyRepository;



    public ReviewService(ReviewRepository reviewRepository, PropertyRepository propertyRepository) {
        this.reviewRepository = reviewRepository;
        this.propertyRepository = propertyRepository;
    }
    public Review addReview(Review review,long propertyId){
        Optional<Property> op = propertyRepository.findById(propertyId);
        if(op.isEmpty()){
            throw  new ResourceNotFoundException("property is not found");
        }
        Property property = op.get();


        return reviewRepository.save(review);
    }
}
