package org.miles.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rider")
public class Rider extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;
    
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;
    
    @Size(max = 255)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Size(max = 255)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rider")
    private List<Rating> ratings;
    
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rider")
    private List<Trip> trips;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "Rider{" + "firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", vehicleNumber=" + vehicleNumber + ", ratings=" + ratings + ", company=" + company + ", trips=" + trips + '}';
    }
}
