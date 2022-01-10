package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.lang.entity.Trip;

@ApplicationScoped
public class TripRepository implements PanacheRepository<Trip> {
    
}
