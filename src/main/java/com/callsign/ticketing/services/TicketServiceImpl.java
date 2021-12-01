package com.callsign.ticketing.services;

import com.callsign.ticketing.data.converters.TicketConverter;
import com.callsign.ticketing.data.entities.Ticket;
import com.callsign.ticketing.data.enums.TicketPriority;
import com.callsign.ticketing.data.repositories.TicketRepository;
import com.callsign.ticketing.data.transactions.TicketRecord;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{
  private final TicketRepository ticketRepository;

  public TicketServiceImpl(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  @Override
  public TicketRecord createTicket(String reason, TicketPriority ticketPriority, Long deliveryId) {
    Ticket ticket = new Ticket(reason, ticketPriority, deliveryId);
    ticketRepository.saveAndFlush(ticket);
    return new TicketConverter().convert(ticket);
  }
}
