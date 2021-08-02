package org.miles.domain;

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
@Table(name = "general_user")
public class GeneralUser extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
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
    
    @OneToOne
    @JoinColumn(name = "user_account_id", referencedColumnName = "id")
    private UserAccount userAccount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    private List<Rating> ratings;
    
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

    @Override
    public String toString() {
        return "GeneralUser{" + "permantAddress=" + permantAddress + ", phoneNumber=" + phoneNumber + ", profilePicture=" + ", requests=" + requests + ", userAccount=" + userAccount + ", ratings=" + ratings + '}';
    }
}
