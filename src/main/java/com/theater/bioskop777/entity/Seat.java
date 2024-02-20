package com.theater.bioskop777.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;



}
