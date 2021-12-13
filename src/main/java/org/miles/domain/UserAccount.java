package org.miles.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.miles.enumeration.UserAccountStatus;
import org.miles.lang.utils.DateUtils;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "user_account")
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Email(message = "Email must be in the form user@domain.com")
    public String email;
    
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "first_name")
    public String firstName;
    
    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "last_name")
    public String lastName;
    
    public String password;

    @Column(name = "phone_number")
    public String phoneNumber;
    
    @Column(name = "is_email_verified")
    public Boolean isEmailVerified;
    
    @NotNull(message = "Status must be set")
    @Enumerated(EnumType.STRING)
    public UserAccountStatus status;
    
    @NotNull(message = "Secret key must be set.")
    @Column(name = "secret_key")
    public String secretKey;
    
    @ManyToMany
    @JoinTable(name = "user_account_authority",
            joinColumns = {@JoinColumn(name = "user_account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    public Set<Authority> authorities = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userAccount", fetch = FetchType.LAZY)
    public GeneralUser generalUser;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userAccount", fetch = FetchType.LAZY)
    public Company company;

    @Column(name = "created_date", updatable = false)
    @JsonIgnore 
    public Instant createdDate = DateUtils.currentInstant();
    
    @Column(name = "last_modified_date")
    @JsonIgnore
    public Instant lastModifiedDate = DateUtils.currentInstant();
    
    public void addRoles(Authority role) {
        authorities.add(role);
    }

    public void removeRoles(Authority role) {
        authorities.remove(role);
    }
}
