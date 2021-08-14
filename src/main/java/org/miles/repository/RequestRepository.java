package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Request;

@ApplicationScoped
public class RequestRepository implements PanacheRepository<Request> {
    
}
