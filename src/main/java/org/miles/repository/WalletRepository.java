package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Wallet;

@ApplicationScoped
public class WalletRepository implements PanacheRepository<Wallet> {
    
}
