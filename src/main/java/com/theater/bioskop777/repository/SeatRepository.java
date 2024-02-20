package com.theater.bioskop777.repository;

import com.theater.bioskop777.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,String> {
}
