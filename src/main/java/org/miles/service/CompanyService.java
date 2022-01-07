package org.miles.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.miles.domain.Company;
import org.miles.domain.Location;
import org.miles.domain.Route;
import org.miles.repository.CompanyRepository;
import org.miles.repository.LocationRepository;
import org.miles.repository.RouteRepository;

@RequestScoped
public class CompanyService {
    
    @Inject
    CompanyRepository companyRepository;

    @Inject
    LocationRepository locationRepository;

    @Inject
    RouteRepository routeRepository;

    @Transactional
    public void addRoute(Long companyId, Long locationId, String routeName){
        Company company =  companyRepository.findByIdOptional(companyId)
            .orElseThrow(IllegalStateException::new);

        Location location = locationRepository.findByIdOptional(locationId)
            .orElseThrow(IllegalStateException::new);
        
        Route route = new Route();
        route.setName(routeName);
        route.setLocation(location);
        routeRepository.persist(route);

        location.getRoutes().add(route);

        company.locations.add(location);
        companyRepository.persist(company);
    }

    @Transactional
    public void addLocation(Long companyId, String name) {
        Company company =  companyRepository.findByIdOptional(companyId)
            .orElseThrow(IllegalStateException::new);
        
        Location location = new Location();
        location.setName(name);
        location.setCompany(company);
    
        locationRepository.persist(location);
    }
}
