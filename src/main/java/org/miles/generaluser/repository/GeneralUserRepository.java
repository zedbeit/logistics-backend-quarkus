package org.miles.generaluser.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import org.miles.generaluser.entity.GeneralUser;

@ApplicationScoped
public class GeneralUserRepository implements PanacheRepository<GeneralUser> {

    // a method that find general user by phone number userAccount
    public Optional<GeneralUser> findGeneralUserByPhoneNumberAndUserAccount(String phone,String userId){
        return find("phoneNumber = ?1 and userAccount.email = ?2",phone, userId).firstResultOptional();
    }

    
    public Optional<GeneralUser> findGeneralUserByPhone(String phone){
        return find("phoneNumber = ?1", phone).firstResultOptional();
    }
    
}
