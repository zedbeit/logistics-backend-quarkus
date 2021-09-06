package org.miles.service;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;
import org.miles.domain.Authority;
import org.miles.domain.Company;
import org.miles.domain.GeneralUser;
import org.miles.domain.UserAccount;
import org.miles.enumeration.Authorities;
import org.miles.enumeration.UserAccountStatus;
import org.miles.repository.AuthorityRepository;
import org.miles.repository.CompanyRepository;
import org.miles.repository.GeneralUserRepository;
import org.miles.repository.UserAccountRepository;
import org.miles.security.service.SecurityUtils;
import org.miles.service.dto.UserAccountDTO;
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
    
    @Inject
    CompanyRepository companyRepository;
    
    @Inject
    SecurityUtils securityUtils;
    
    @Transactional
    public UserAccountDTO createGeneralUser(UserAccountVM userAccountDTO){
        
        UserAccount userAccount = userAccountVmMapper.toEntity(userAccountDTO);
        
        Authority authority = authorityRepository.findByName(Authorities.ROLE_GENERAL_USER.toString())  
                .orElseThrow(IllegalStateException::new);
        userAccount.addRoles(authority);

        Map<String, String> credMap = securityUtils.hashPassword(userAccount.getPassword());
        
        userAccount.setPassword(credMap.get("hashedPassword"));
        userAccount.setSecretKey(credMap.get("salt"));
       
        userAccount.setIsEmailVerified(Boolean.FALSE);
        userAccount.setStatus(UserAccountStatus.ACTIVE);
        
        userAccountRepository.persist(userAccount);
        
        // Create general user instance
        GeneralUser generalUser = new GeneralUser();
        
        generalUser.setId(userAccount.getId());
        generalUser.setUserAccount(userAccount);
        
        generalUserRepository.persist(generalUser);
       
        credMap = null;
        
        return userAccountMapper.toDto(userAccount);
    }
    
    @Transactional
    public UserAccountDTO createCompany(UserAccountVM userAccountVM){
        String companyName = userAccountVM.companyName;
        
        UserAccount userAccount = userAccountVmMapper.toEntity(userAccountVM);
        
        Map<String, String> credMap = securityUtils.hashPassword(userAccount.getPassword());
        
        userAccount.setPassword(credMap.get("hashedPassword"));
        userAccount.setSecretKey(credMap.get("salt"));
        
        Authority authority = authorityRepository.findByName(Authorities.ROLE_COMPANY.toString())  
                .orElseThrow(IllegalStateException::new);
        userAccount.addRoles(authority);
        
        userAccount.setIsEmailVerified(Boolean.FALSE);
        userAccount.setStatus(UserAccountStatus.ACTIVE);
        
        userAccountRepository.persist(userAccount);
        
        // Create comapny instance
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setId(userAccount.getId());
        company.setUserAccount(userAccount);
        
        companyRepository.persist(company);
        credMap = null;
        return userAccountMapper.toDto(userAccount);
    }
}
