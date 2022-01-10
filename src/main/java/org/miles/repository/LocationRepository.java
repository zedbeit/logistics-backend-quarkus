package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.miles.domain.Location;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {

    public Optional<Location> findLocationByName(String location) {
        return find("name", location).firstResultOptional();
    }
}
