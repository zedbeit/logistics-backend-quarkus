package org.miles.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.miles.lang.utils.DateUtils;

@Entity
@Table(name = "general_user")
public class GeneralUser implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull(message = "Id must be set")
    private Long id;
    
    @Size(max = 255)
    @Column(name = "permant_address")
    private String permantAddress;
    
    @Size(max = 255)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture")
    private byte[] profilePicture;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    private List<Request> requests;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    private List<Rating> ratings;

    @Column(name = "created_date", updatable = false)
    @JsonIgnore 
    private Instant createdDate = DateUtils.currentInstant();
    
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = DateUtils.currentInstant();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPermantAddress() {
        return permantAddress;
    }

    public void setPermantAddress(String permantAddress) {
        this.permantAddress = permantAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Request> getRequests() {
        return requests;
    }
    
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    @Override
    public String toString() {
        return "GeneralUser{" + "permantAddress=" + permantAddress + ", phoneNumber=" + phoneNumber + ", profilePicture=" + ", requests=" + requests + ", userAccount=" + userAccount + ", ratings=" + ratings + '}';
    }
}
