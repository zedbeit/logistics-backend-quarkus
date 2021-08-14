package org.miles.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.miles.enumeration.UserAccountStatus;

@Entity
@Table(name = "user_account")
public class UserAccount extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @NotNull
    private String email;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String password;
    
    @Column(name = "is_email_verified")
    private Boolean isEmailVerified;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserAccountStatus status;
    
    @NotNull
    @Column(name = "secret_key")
    private String secretKey;
    
    @ManyToMany
    @JoinTable(name = "user_account_authority",
            joinColumns = {@JoinColumn(name = "user_account_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsEmailVerified() {
        return isEmailVerified;
    }

    public void setIsEmailVerified(Boolean isEmailVerified) {
        this.isEmailVerified = isEmailVerified;
    }

    public UserAccountStatus getStatus() {
        return status;
    }

    public void setStatus(UserAccountStatus status) {
        this.status = status;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", isEmailVerified=" + isEmailVerified + ", status=" + status + ", secretKey=" + secretKey + ", authorities=" + authorities + '}';
    }   
}
