package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Company;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
    
}
