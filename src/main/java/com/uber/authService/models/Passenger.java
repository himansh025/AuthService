package com.uber.authService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Passenger extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private  String phoneNumber;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "passenger") //here we have to define to whom this booking is pass or driver
    private List<Booking> bookings = new ArrayList<>();


}
