package org.miles.lang.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import org.miles.lang.entity.Authority;

@ApplicationScoped
public class AuthorityRepository implements PanacheRepository<Authority> {
    public Optional<Authority> findByName(String name){
        return find("name",name).firstResultOptional();
    }
}
