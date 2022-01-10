package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.miles.lang.entity.Location;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class LocationRepository implements PanacheRepository<Location> {

    public Optional<Location> findLocationByName(String location) {
        return find("name", location).firstResultOptional();
    }
}
