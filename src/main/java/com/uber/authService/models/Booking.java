package com.uber.authService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@SuperBuilder
@Entity
public class Booking extends BaseModel {

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    @Override
    public String toString() {
        return "Booking{" +
                "bookingStatus=" + bookingStatus +
                ", totalDistance=" + totalDistance +
                ", driver=" + driver +
                ", passenger=" + passenger +
                ", id=" + id +
                '}';
    }

    private Long totalDistance;


    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver; //here we have to define to whom this booking

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger; //here we have to define to whom this booking

}