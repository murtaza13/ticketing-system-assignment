package com.callsign.ticketing.evaluators.tickets;

import com.callsign.ticketing.data.entities.Delivery;
import com.callsign.ticketing.data.enums.TicketPriority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EstimatedTimeOFDeliveryGreaterThanExpectedTime implements TicketEvaluator {
  @Override
  public boolean evaluate(Delivery delivery) {
    int estimatedTimeRequiredInSeconds = delivery.getRestaurant().getMeanTimeToPrepareFoodInSeconds() +
        delivery.getTimeToReachDestinationInSeconds();
    LocalDateTime estimatedDeliveryTime = delivery.getCreatedAt().plusSeconds(estimatedTimeRequiredInSeconds);
    return estimatedDeliveryTime.isAfter(delivery.getExpectedDeliveryTime());
  }

  @Override
  public TicketPriority getDefaultTicketPriority() {
    return TicketPriority.MEDIUM;
  }
}
