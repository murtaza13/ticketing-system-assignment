package com.callsign.ticketing.data.converters;

import com.callsign.ticketing.data.entities.Ticket;
import com.callsign.ticketing.data.transactions.TicketRecord;

public class TicketConverter implements EntityTransactionConverter<Ticket, TicketRecord> {

  @Override
  public TicketRecord convert(Ticket ticket) {
    return new TicketRecord(
        ticket.getTicketId(),
        "",
        ticket.getTicketPriority(),
        ticket.getDelivery()
    );
  }
}
