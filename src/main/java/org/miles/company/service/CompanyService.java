package org.miles.company.service;

import org.miles.company.entity.Company;
import org.miles.lang.entity.Location;
import org.miles.lang.entity.Route;
import org.miles.company.repository.CompanyRepository;
import org.miles.lang.repository.LocationRepository;
import org.miles.lang.repository.RouteRepository;
import org.miles.company.dto.CompanyDTO;
import org.miles.company.service.mapper.CompanyMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CompanyService {
    
    @Inject
    CompanyRepository companyRepository;

    @Inject
    LocationRepository locationRepository;

    @Inject
    RouteRepository routeRepository;

    @Inject
    CompanyMapper companyMapper;

    @Transactional
    public void addLocation(Long companyId, String name) {
        Company company =  companyRepository.findByIdOptional(companyId)
                .orElseThrow(IllegalStateException::new);

        Location location = new Location();
        location.setName(name);
        company.locations.add(name);

        companyRepository.persist(company);
        locationRepository.persist(location);
    }

    @Transactional
    public void addRoute(Long companyId, String locationName, String routeName) {
        Company company =  companyRepository.findByIdOptional(companyId)
            .orElseThrow(IllegalStateException::new);

        boolean exist = locationRepository.findLocationByName(locationName).isPresent();
        
        if(!exist){
            throw new IllegalStateException("Location does not exist.");
        }
        
        Route route = new Route();
        route.setName(routeName);
        route.setLocation(locationName);

        company.routes.add(route.getName());

        routeRepository.persist(route);
        companyRepository.persist(company);
    }

    public List<CompanyDTO> getCompaniesWithMatchingRoute(String location, String src, String dest){

        List<Company> companies = companyRepository.getAllCompanies();

        List<Company> matchingCompanies = new ArrayList<>();

        companies.forEach(company -> {
            if(company.locations.contains(location) && company.routes.contains(src) && company.routes.contains(dest)){
                matchingCompanies.add(company);
            }
        });
        return matchingCompanies.stream()
                .map(companyMapper::toDto)
                .collect(Collectors.toList());
    }
}
