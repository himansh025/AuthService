package com.uber.authService.controllers;

import com.uber.authService.dtos.PassengerDto;
import com.uber.authService.dtos.PassengerSignupDto;
import com.uber.authService.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup")
public class AuthController {

    private AuthService authService;

    public  AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/")
    public ResponseEntity<?> signupPassenger(@RequestBody PassengerSignupDto passengerSignupDto){
        try{
            PassengerDto res= this.authService.signupPassenger(passengerSignupDto);
            return  new ResponseEntity<>(res, HttpStatus.CREATED);
        }catch(Exception e){
        return  new ResponseEntity<>("failed to signup passenger",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
