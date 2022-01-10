package org.miles.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.miles.lang.entity.Rating;
import org.miles.lang.entity.Request;
import org.miles.lang.entity.Rider;
import org.miles.lang.entity.Vehicle;
import org.miles.lang.utils.DateUtils;
import org.miles.useraccount.entity.UserAccount;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @NotNull(message = "ID must be set")
    public Long id;
    
    @Size(max = 255)
    @NotNull(message = "Company name must be set")
    @Column(name = "company_name")
    public String companyName;
    
    @Size(max = 255)
    @Column(name = "company_address")
    public String companyAddress;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "cac_document")
    public byte[] cacDocument;
    
    @Size(max = 255)
    @Column(name = "bvn_number")
    public String bvnNumber;
    
    @Column(name = "price_per_km")
    public BigDecimal pricePerKm;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<Request> requests;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<Rating> ratings;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<Rider> riders;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    public List<Vehicle> vehicles;
    
    @OneToOne   
    @JoinColumn(name = "id", referencedColumnName = "id")
    public UserAccount userAccount;
    
    @ElementCollection(targetClass = String.class)
    public List<String> routes = new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    public List<String> locations = new ArrayList<>();

    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    public Instant createdDate = DateUtils.currentInstant();
    
    @Column(name = "last_modified_date")
    @JsonIgnore
    public Instant lastModifiedDate = DateUtils.currentInstant();

}