package com.uber.authService.dtos;

import com.uber.authService.models.Passenger;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PassengerDto {
    private  Long id;
    private String email;
    private String phoneNumber;
    private String password;
    private String name;
    private Date createAt;

    public static   PassengerDto from (Passenger p){
        PassengerDto result= PassengerDto.builder()
                .id(p.getId())
                .name(p.getName())
                .email(p.getEmail())
                .phoneNumber(p.getPhoneNumber())
                .createAt(p.getCreatedAt())
                .password(p.getPassword())
                .build();
        return result;
    }
}
