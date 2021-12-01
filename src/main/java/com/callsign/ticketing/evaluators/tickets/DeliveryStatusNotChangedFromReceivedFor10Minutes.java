package com.callsign.ticketing.evaluators.tickets;

import com.callsign.ticketing.data.entities.Delivery;
import com.callsign.ticketing.data.enums.DeliveryStatus;
import com.callsign.ticketing.data.enums.TicketPriority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DeliveryStatusNotChangedFromReceivedFor10Minutes implements TicketConditionEvaluator {
  @Override
  public boolean evaluate(Delivery delivery) {
    return LocalDateTime.now().isAfter(delivery.getCreatedAt().plusMinutes(10)) &&
        delivery.getDeliveryStatus().equals(DeliveryStatus.RECEIVED);
  }

  @Override
  public TicketPriority getDefaultTicketPriority() {
    return TicketPriority.LOW;
  }
}
