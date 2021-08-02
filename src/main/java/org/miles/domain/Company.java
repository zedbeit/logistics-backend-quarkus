package org.miles.domain;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "company")
public class Company extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 255)
    @Column(name = "company_name")
    private String companyName;
    
    @Size(max = 255)
    @Column(name = "company_address")
    private String companyAddress;
    
    @Size(max = 255)
    @Column(name = "company_phone_number")
    private String companyPhoneNumber;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "cac_document")
    private byte[] cacDocument;
    
    @Size(max = 255)
    @Column(name = "bvn_number")
    private String bvnNumber;
    
    @Column(name = "price_per_km")
    private BigDecimal pricePerKm;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Request> requests;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Rating> ratings;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Rider> riders;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Vehicle> vehicles;
    
    @OneToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<State> states;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public byte[] getCacDocument() {
        return cacDocument;
    }

    public void setCacDocument(byte[] cacDocument) {
        this.cacDocument = cacDocument;
    }

    public String getBvnNumber() {
        return bvnNumber;
    }

    public void setBvnNumber(String bvnNumber) {
        this.bvnNumber = bvnNumber;
    }

    public BigDecimal getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public void setRiders(List<Rider> riders) {
        this.riders = riders;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Company{" + "companyName=" + companyName + ", companyAddress=" + companyAddress + ", companyPhoneNumber=" + companyPhoneNumber + ", cacDocument=" + ", bvnNumber=" + bvnNumber + ", pricePerKm=" + pricePerKm + ", requests=" + requests + ", ratings=" + ratings + ", riders=" + riders + ", vehicles=" + vehicles + ", userAccount=" + userAccount + ", states=" + states + '}';
    }
    
}
