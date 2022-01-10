package org.miles.useraccount.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import org.miles.useraccount.entity.UserAccount;
import org.miles.lang.enums.UserAccountStatus;

@ApplicationScoped
public class UserAccountRepository implements PanacheRepository<UserAccount> {
    
    public Optional<UserAccount> findActiveUserAccountByEmailAndPassword(String email, String password){
        Map<String, Object> params = new HashMap<>();        
        params.put("email", email);
        params.put("password", password);
        params.put("status", UserAccountStatus.ACTIVE);
        
        return find("email = :email and password = :password and status = :status", params).firstResultOptional();  
    }
    
    public Optional<UserAccount> findActiveUserAccountByEmail(String email){
        Map<String, Object> params = new HashMap<>();        
        params.put("email", email);
        params.put("status", UserAccountStatus.ACTIVE);
        
        return find("email = :email and status = :status", params).firstResultOptional();  
    }
}
