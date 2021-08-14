package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Card;

@ApplicationScoped
public class CardRepository implements PanacheRepository<Card> {
    
}
