package com.callsign.ticketing.evaluators.tickets;

import com.callsign.ticketing.data.entities.Delivery;
import com.callsign.ticketing.data.enums.TicketPriority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExpectedTimeOfDeliveryPassedTicketEvaluator implements TicketEvaluator {
  @Override
  public boolean evaluate(Delivery delivery) {
    return LocalDateTime.now().isBefore(delivery.getExpectedDeliveryTime());
  }

  @Override
  public TicketPriority getDefaultTicketPriority() {
    return TicketPriority.HIGH;
  }
}
