package com.uber.authService.services;

import com.uber.authService.dtos.PassengerDto;
import com.uber.authService.dtos.PassengerSignupDto;
import com.uber.authService.models.Passenger;
import com.uber.authService.repositories.PassengerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
public class AuthService {

    private final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignupDto passengerSignupDto) {
        String hashPassword = this.bCryptPasswordEncoder.encode(passengerSignupDto.getPassword());
        Passenger passenger = Passenger.builder()
                .name(passengerSignupDto.getName())
                .email(passengerSignupDto.getEmail())
                .phoneNumber(hashPassword)
                .password(passengerSignupDto.getPassword())
                .build();
        Passenger res = this.passengerRepository.save(passenger);
        return PassengerDto.from(res);
    }
}
