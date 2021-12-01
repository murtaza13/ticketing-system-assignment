package com.callsign.callsignticketing.configurations;

import com.callsign.ticketing.CallsignTicketingApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication(scanBasePackages = {
    "com.callsign.ticketing.configurations",
    "com.callsign.ticketing.controllers",
    "com.callsign.ticketing.data",
    "com.callsign.ticketing.jobs",
    "com.callsign.ticketing.evaluators",
    "com.callsign.ticketing.services"
})
@EnableJpaRepositories(basePackages = "com.callsign.ticketing.data.repositories")
@EntityScan(basePackages = "com.callsign.ticketing.data.entities")
@TestPropertySource("file:config/test-application.properties")
public class TestConfiguration {
}
