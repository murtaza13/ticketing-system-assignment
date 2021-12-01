package com.callsign.ticketing.data.repositories;

import com.callsign.ticketing.data.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
