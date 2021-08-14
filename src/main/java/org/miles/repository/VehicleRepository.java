package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Vehicle;

@ApplicationScoped
public class VehicleRepository implements PanacheRepository<Vehicle> {
    
}
