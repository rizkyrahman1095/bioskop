package com.theater.bioskop777.repository;

import com.theater.bioskop777.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
