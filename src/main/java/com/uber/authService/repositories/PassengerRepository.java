package com.uber.authService.repositories;

import com.uber.authService.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {

    Passenger findPassengerByEmail(String email);
}
