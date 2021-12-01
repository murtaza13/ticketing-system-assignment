package com.callsign.ticketing.services;

import com.callsign.ticketing.data.enums.TicketPriority;
import com.callsign.ticketing.data.transactions.TicketRecord;

public interface TicketService {
  TicketRecord createTicket(String reason, TicketPriority ticketPriority, Long deliveryId);
}
