package org.miles.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vehicle")
public class Vehicle extends AbstractEntity {
    
    @NotNull
    @Size(max = 100)
    private String type;
    
    @Column(name = "vehicle_usage_price")
    private BigDecimal vehicleUsagePrice;
    
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getVehicleUsagePrice() {
        return vehicleUsagePrice;
    }

    public void setVehicleUsagePrice(BigDecimal vehicleUsagePrice) {
        this.vehicleUsagePrice = vehicleUsagePrice;
    }
    
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "type=" + type + ", vehicleUsagePrice=" + vehicleUsagePrice + ", company=" + company + '}';
    }
}
