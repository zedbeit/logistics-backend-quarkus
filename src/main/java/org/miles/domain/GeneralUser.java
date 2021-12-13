package org.miles.domain;


import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@DiscriminatorValue("GENERAL_USER")
@Entity
@Table(name = "general_user")
public class GeneralUser extends UserAccount{
    
    @Size(max = 255)
    @Column(name = "permant_address")
    public String permantAddress;
    
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture")
    public byte[] profilePicture;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    public List<Request> requests;
    
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    public UserAccount userAccount;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalUser")
    public List<Rating> ratings;
}
