package com.airbnb.service;

import com.airbnb.entity.PropertyUser;
import com.airbnb.repository.PropertyUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private PropertyUserRepository userRepository;

    public UserService(PropertyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PropertyUser addUser(PropertyUser user) {
        PropertyUser u = PropertyUser.builder().
                firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobile(user.getMobile())
                .username(user.getUsername())
                .build();
        return userRepository.save(u);
    }
}
