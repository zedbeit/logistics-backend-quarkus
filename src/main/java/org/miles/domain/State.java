package org.miles.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "states")
public class State extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Size(max = 45)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private List<Route> routes;
    
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "State{" + "name=" + name + ", routes=" + routes + ", company=" + company + '}';
    }
    
}
