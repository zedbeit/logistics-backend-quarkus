package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.lang.entity.Rating;

@ApplicationScoped
public class RatingRepository implements PanacheRepository<Rating> {
    
}
