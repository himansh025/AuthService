package com.uber.authService.controllers;

import com.uber.authService.dtos.AuthRequestDto;
import com.uber.authService.dtos.PassengerDto;
import com.uber.authService.dtos.PassengerSignupDto;
import com.uber.authService.services.AuthService;
import com.uber.authService.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //@Value("${cookie.expiry}")
    private int expiryCookie = 24 * 7 * 3600;
    private AuthService authService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;


    public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupPassenger(@RequestBody PassengerSignupDto passengerSignupDto) {
            PassengerDto res = this.authService.signupPassenger(passengerSignupDto);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signInPassenger(@RequestBody AuthRequestDto authRequestDto, HttpServletResponse response) {
//                used for authentication requests
            Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
            if (authentication.isAuthenticated()) {
                String jwtToken = jwtUtil.createToken(authRequestDto.getEmail());
                ResponseCookie cookie = ResponseCookie.from("JwtToken", jwtToken)
                        .httpOnly(true)
                        .maxAge(expiryCookie)
                        .secure(false)
                        .build();
                response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
                return new ResponseEntity<>(jwtToken, HttpStatus.OK);
            } else {
                throw new UsernameNotFoundException("not found user email");
            }

    }
}
