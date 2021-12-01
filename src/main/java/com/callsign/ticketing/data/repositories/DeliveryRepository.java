package com.callsign.ticketing.data.repositories;

import com.callsign.ticketing.data.entities.Delivery;
import com.callsign.ticketing.data.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.Set;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

  @Transactional(propagation = Propagation.MANDATORY)
  @Query(value = "select d.* from delivery d where delivery_status <> ?1 limit ?2 for update skip locked", nativeQuery = true)
  Set<Delivery> fetchAllDeliveriesWithStatusNotEqual(DeliveryStatus deliveryStatus, int limit);
}
