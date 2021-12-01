package com.callsign.ticketing.evaluators.tickets;

import com.callsign.ticketing.data.entities.Delivery;
import com.callsign.ticketing.data.enums.TicketPriority;

public interface TicketEvaluator {
  default String getEvaluatorId(){
    return this.getClass().getName();
  };
  boolean evaluate(Delivery delivery);
  TicketPriority getDefaultTicketPriority();
}
