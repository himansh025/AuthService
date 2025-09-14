package com.uber.authService.services;

import com.example.Uber_Entity.models.Passenger;
import com.uber.authService.dtos.PassengerDto;
import com.uber.authService.dtos.PassengerSignupDto;
import com.uber.authService.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ;

    public AuthService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignupDto passengerSignupDto) {
        String hashPassword = passwordEncoder().encode(passengerSignupDto.getPassword());
        Passenger passenger = Passenger.builder()
                .name(passengerSignupDto.getName())
                .email(passengerSignupDto.getEmail())
                .phoneNumber(passengerSignupDto.getPhoneNumber())
                .password(hashPassword)
                .build();
        Passenger res = this.passengerRepository.save(passenger);
        return PassengerDto.from(res);
    }
}
