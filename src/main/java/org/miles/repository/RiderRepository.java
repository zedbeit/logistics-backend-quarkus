package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Rider;

@ApplicationScoped
public class RiderRepository implements PanacheRepository<Rider> {
    
}
