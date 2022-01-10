package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.lang.entity.Payment;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<Payment> {
    
}
