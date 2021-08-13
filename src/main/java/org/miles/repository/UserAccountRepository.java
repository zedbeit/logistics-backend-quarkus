package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.UserAccount;

@ApplicationScoped
public class UserAccountRepository implements PanacheRepository<UserAccount> {
    
}
