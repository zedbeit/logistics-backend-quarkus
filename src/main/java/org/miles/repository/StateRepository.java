package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.State;

@ApplicationScoped
public class StateRepository implements PanacheRepository<State> {
    
}
