package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.miles.lang.entity.Route;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RouteRepository implements PanacheRepository<Route> {

}
