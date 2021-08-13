package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Route;

@ApplicationScoped
public class RouteRepository implements PanacheRepository<Route> {
    
}
