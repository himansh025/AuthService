package com.uber.authService.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "booking_review")
public class Review extends BaseModel {


    // 1:1 mapping btw the booking and review

    // when our booking table is depends on the review then instead of doing the review save first then use hte obj in the booking saved soring cascade done it manually
    // remove if booking is remove review associated is also removed
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return "Review{" +
                "booking=" + booking.getId() +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Column(nullable = false)
    private String content;

    private Double rating;


}
