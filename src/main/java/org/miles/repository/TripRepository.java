package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Trip;

@ApplicationScoped
public class TripRepository implements PanacheRepository<Trip> {
    
}
