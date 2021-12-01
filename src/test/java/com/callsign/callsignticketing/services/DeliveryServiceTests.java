package com.callsign.callsignticketing.services;

import com.callsign.callsignticketing.configurations.TestConfiguration;
import com.callsign.ticketing.data.enums.TicketPriority;
import com.callsign.ticketing.services.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration(classes = TestConfiguration.class)
@TestPropertySource("file:src/test/resources/test-application.properties")
public class DeliveryServiceTests {

  @Test
  public void firstTest(){
    String s = "";
    ticketService.createTicket("hahah", TicketPriority.LOW, 1L);
  }

  @Autowired
  private TicketServiceImpl ticketService;
}
