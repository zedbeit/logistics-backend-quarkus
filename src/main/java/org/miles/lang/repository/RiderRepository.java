package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.lang.entity.Rider;

@ApplicationScoped
public class RiderRepository implements PanacheRepository<Rider> {
    
}
