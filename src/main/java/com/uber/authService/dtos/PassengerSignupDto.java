package com.uber.authService.dtos;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PassengerSignupDto {
    private String email;
    private String phoneNumber;
    private String password;
    private String name;

}
