package org.miles.company.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.miles.company.entity.Company;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
    public Optional<Company> findCompanyByName(String companyName){
        return find("companyName", companyName).firstResultOptional();  
    }

    public List<Company> getAllCompanies() {
        return find("SELECT c FROM Company c").list();
    }

    // fetch company by location e.g company where location is equal to 'kano'
}
