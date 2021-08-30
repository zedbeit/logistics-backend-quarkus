package org.miles.service;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.miles.domain.GeneralUser;
import org.miles.domain.UserAccount;
import org.miles.lang.exception.InvalidRequestException;
import org.miles.lang.utils.DateUtils;
import org.miles.repository.GeneralUserRepository;
import org.miles.repository.UserAccountRepository;
import org.miles.service.dto.GeneralUserDTO;
import org.miles.service.mapper.GeneralUserMapper;

@RequestScoped
public class GeneralUserService {
    @Inject
    GeneralUserMapper generalUserMapper;
    @Inject
    GeneralUserRepository generalUserRepository;
    @Inject
    UserAccountRepository userAccountRepository;

    UserAccount userAccount;
    
    
    //method to create the general user
    @Transactional
    public GeneralUser createGeneralUser(GeneralUserDTO generalUserDto, String userId){

        //make sure general user has an account

        GeneralUser generalUser = generalUserMapper.toEntity(generalUserDto);
        // generalUser.setUserAccount(userAccount);

        if(generalUserDto == null || generalUserDto.permantAddress == null || generalUserDto.permantAddress.isBlank() || generalUserDto.phoneNumber == null || generalUserDto.phoneNumber.isBlank()){
            throw new InvalidRequestException("Permanent address and or phone number must be provided");
        }

        Optional<GeneralUser> existingGeneralUser = generalUserRepository.findGeneralUserByPhone(generalUser.getPhoneNumber()); 
        if(existingGeneralUser.isPresent()){
           GeneralUser existingUser = existingGeneralUser.get();
           existingUser.setPermantAddress(existingUser.getPermantAddress());
           existingUser.setPhoneNumber(existingUser.getPhoneNumber());
           existingUser.setLastModifiedDate(DateUtils.currentInstant());
           generalUser = existingUser;
        }
        generalUserRepository.persist(generalUser);
        return generalUser;
    }


}
