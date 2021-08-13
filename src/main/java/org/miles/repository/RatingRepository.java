package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Rating;

@ApplicationScoped
public class RatingRepository implements PanacheRepository<Rating> {
    
}
