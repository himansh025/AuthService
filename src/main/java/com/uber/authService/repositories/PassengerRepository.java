package com.uber.authService.repositories;

import com.example.Uber_Entity.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

    Optional<Passenger> findPassengerByEmail(String email);
}
