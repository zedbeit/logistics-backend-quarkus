package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.miles.domain.Route;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RouteRepository implements PanacheRepository<Route> {

}
