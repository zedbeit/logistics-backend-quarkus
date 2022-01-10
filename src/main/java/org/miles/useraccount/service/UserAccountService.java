package org.miles.useraccount.service;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.jboss.logging.Logger;
import org.miles.lang.entity.Authority;
import org.miles.company.entity.Company;
import org.miles.generaluser.entity.GeneralUser;
import org.miles.useraccount.entity.UserAccount;
import org.miles.lang.enums.Authorities;
import org.miles.lang.enums.UserAccountStatus;
import org.miles.lang.exception.CompanyAlreadyExistException;
import org.miles.lang.exception.EmailAlreadyExistException;
import org.miles.lang.exception.PreconditionFailedException;
import org.miles.lang.repository.AuthorityRepository;
import org.miles.company.repository.CompanyRepository;
import org.miles.generaluser.repository.GeneralUserRepository;
import org.miles.useraccount.repository.UserAccountRepository;
import org.miles.security.util.SecurityUtils;
import org.miles.useraccount.dto.UserAccountDTO;
import org.miles.useraccount.dto.vm.UserAccountVM;
import org.miles.useraccount.service.mapper.UserAccountMapper;
import org.miles.useraccount.service.mapper.UserAccountVmMapper;

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
    
    @Transactional
    public UserAccountDTO createGeneralUser(UserAccountVM userAccountDTO){
        if (userAccountDTO == null || userAccountDTO.password == null || userAccountDTO.email == null || userAccountDTO.firstName == null || userAccountDTO.lastName == null) {
            throw new PreconditionFailedException("Email, First name, Last name, Password must be provided");
        }
        if(userAccountDTO.password.length() < 8){
            throw new PreconditionFailedException("Password must be atleast 8 characters");
        }
        
        if (userAccountRepository.findActiveUserAccountByEmail(userAccountDTO.email).isPresent()) {
            throw new EmailAlreadyExistException("Email Already exist");
        }
        
        UserAccount userAccount = userAccountVmMapper.toEntity(userAccountDTO);
        
        Map<String, String> credMap = SecurityUtils.hashPassword(userAccount.password);
        
        userAccount.password = credMap.get("hashedPassword");
        userAccount.secretKey = credMap.get("salt");
       
        userAccount.isEmailVerified = Boolean.FALSE;
        userAccount.status = UserAccountStatus.ACTIVE;
        
        Authority authority = authorityRepository.findByName(Authorities.ROLE_GENERAL_USER.toString())  
        .orElseThrow(IllegalStateException::new);
        userAccount.addRoles(authority);
       
        userAccountRepository.persist(userAccount);
        
        // Create general user instance
        GeneralUser generalUser = new GeneralUser();
        
        generalUser.id = userAccount.getId();
        generalUser.userAccount = userAccount;
        
        generalUserRepository.persist(generalUser);

        credMap = null;
        
        return userAccountMapper.toDto(userAccount);
    }
    
    @Transactional
    public UserAccountDTO createCompany(UserAccountVM userAccountDTO){
        if (userAccountDTO == null || userAccountDTO.password == null || userAccountDTO.email == null || userAccountDTO.firstName == null || userAccountDTO.lastName == null) {
            throw new PreconditionFailedException("Email, First name, Last name, Password must be provided.");
        }
        if(userAccountDTO.companyName == null || userAccountDTO.companyName.isBlank()){
            throw new PreconditionFailedException("Company name must be provided.");
        }
        
        if(userAccountDTO.password.length() < 8){
            throw new PreconditionFailedException("Password must be atleast 8 characters.");
        }
        
        if (userAccountRepository.findActiveUserAccountByEmail(userAccountDTO.email).isPresent()) {
            throw new EmailAlreadyExistException("Email Already exist");
        }
        
        if (companyRepository.findCompanyByName(userAccountDTO.companyName).isPresent()) {
            throw new CompanyAlreadyExistException("Company name Already exist");
        }
        String companyName = userAccountDTO.companyName;
        
        UserAccount userAccount = userAccountVmMapper.toEntity(userAccountDTO);
        
        Map<String, String> credMap = SecurityUtils.hashPassword(userAccount.password);
        
        userAccount.password = credMap.get("hashedPassword");
        userAccount.secretKey = credMap.get("salt");
        
        Authority authority = authorityRepository.findByName(Authorities.ROLE_COMPANY.toString())  
                .orElseThrow(IllegalStateException::new);
        userAccount.addRoles(authority);
        
        userAccount.isEmailVerified = Boolean.FALSE;
        userAccount.status = UserAccountStatus.ACTIVE;
        
        userAccountRepository.persist(userAccount);
        
        // Create comapny instance
        Company company = new Company();
        company.companyName = companyName;
        company.id = userAccount.getId();
        company.userAccount = userAccount;
        
        companyRepository.persist(company);
        
        credMap = null;
        return userAccountMapper.toDto(userAccount);
    }
}
