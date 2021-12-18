package org.miles.domain;


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

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.miles.lang.utils.DateUtils;


@Entity
@Table(name = "general_user")
public class GeneralUser implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull(message = "Id must be set")
    public Long id;
    
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

    @Column(name = "created_date", updatable = false)
    @JsonIgnore 
    public Instant createdDate = DateUtils.currentInstant();
    
    @Column(name = "last_modified_date")
    @JsonIgnore
    public Instant lastModifiedDate = DateUtils.currentInstant();
}
