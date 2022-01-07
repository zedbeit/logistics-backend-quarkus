package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Location;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {
    
}
