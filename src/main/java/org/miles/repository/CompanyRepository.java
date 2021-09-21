package org.miles.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import org.miles.domain.Company;
import org.miles.enumeration.UserAccountStatus;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
    public Optional<Company> findCompanyByName(String companyName){
        return find("companyName", companyName).firstResultOptional();  
    }
}
