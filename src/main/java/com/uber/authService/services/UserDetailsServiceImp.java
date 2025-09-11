package com.uber.authService.services;

import com.uber.authService.models.Passenger;
import com.uber.authService.repositories.PassengerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private PassengerRepository passengerRepository;
    UserDetailsServiceImp (PassengerRepository passengerRepository){
        this.passengerRepository=passengerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Passenger>passenger= this.passengerRepository.findPassengerByEmail(email);
      if(passenger.isPresent()){
          return  new AuthPassengerDetails(passenger.get());
      }else{
          throw new UsernameNotFoundException("Cannot find the Passenger by the given Email");
      }
    }
}
