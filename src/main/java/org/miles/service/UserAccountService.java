package org.miles.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;
import org.miles.domain.Authority;
import org.miles.domain.GeneralUser;
import org.miles.domain.UserAccount;
import org.miles.enumeration.Authorities;
import org.miles.enumeration.UserAccountStatus;
import org.miles.repository.AuthorityRepository;
import org.miles.repository.GeneralUserRepository;
import org.miles.repository.UserAccountRepository;
import org.miles.service.dto.CompanyDTO;
import org.miles.service.dto.UserAccountDTO;
import org.miles.service.dto.vm.CompanyVM;
import org.miles.service.dto.vm.UserAccountVM;
import org.miles.service.mapper.UserAccountMapper;
import org.miles.service.mapper.UserAccountVmMapper;

@RequestScoped
public class UserAccountService {
    private Logger LOGGER = Logger.getLogger(UserAccountService.class);
    
    @Inject
    UserAccountMapper userAccountMapper;
    
    @Inject
    UserAccountVmMapper userAccountVmMapper;
    
    @Inject
    UserAccountRepository userAccountRepository;
    
    @Inject
    AuthorityRepository authorityRepository;
    
    @Inject
    GeneralUserRepository generalUserRepository;
    
    @Transactional
    public UserAccountDTO createGeneralUser(UserAccountVM userAccountDTO){
        
        UserAccount userAccount = userAccountVmMapper.toEntity(userAccountDTO);
        
        Authority authority = authorityRepository.findByName(Authorities.ROLE_GENERAL_USER.toString())  
                .orElseThrow(IllegalStateException::new);

        userAccount.addRoles(authority);
        
        userAccount.setIsEmailVerified(Boolean.FALSE);
        userAccount.setStatus(UserAccountStatus.ACTIVE);
        
        // The secretKey will be useful when we are doing encryption.
        // for now its just some dummy text.
        userAccount.setSecretKey("djadandn");
        
        userAccountRepository.persist(userAccount);
        
        // Create general user instance
        GeneralUser generalUser = new GeneralUser();
        
        generalUser.setId(userAccount.getId());
        generalUser.setUserAccount(userAccount);
        
        generalUserRepository.persist(generalUser);
       
        return userAccountMapper.toDto(userAccount);
    }
    
    public CompanyDTO createCompany(CompanyVM companyVM){
        return null;
    }
}
