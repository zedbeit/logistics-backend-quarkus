package org.miles.lang.entity;

import org.miles.company.entity.Company;
import org.miles.generaluser.entity.GeneralUser;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rating")
public class Rating extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 45)
    private String rating;
    
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name = "general_user_id", referencedColumnName = "id")
    private GeneralUser generalUser;
    
    @ManyToOne
    @JoinColumn(name = "rider_id", referencedColumnName = "id")
    private Rider rider;
    
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public GeneralUser getGeneralUser() {
        return generalUser;
    }

    public void setGeneralUser(GeneralUser generalUser) {
        this.generalUser = generalUser;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public String toString() {
        return "Rating{" + "rating=" + rating + ", company=" + company + ", generalUser=" + generalUser + ", rider=" + rider + '}';
    }
}
