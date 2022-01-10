package org.miles.useraccount.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.service.mapper.EntityMapper;
import org.miles.useraccount.entity.UserAccount;
import org.miles.useraccount.dto.UserAccountDTO;

@Mapper(componentModel = "cdi")
public interface UserAccountMapper extends EntityMapper<UserAccountDTO, UserAccount> {

    @Override
    public UserAccountDTO toDto(UserAccount entity);

    @Override
    @Mapping(target="password",ignore=true)
    @Mapping(target="secretKey",ignore=true)
    @Mapping(target="authorities",ignore=true)
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="status",ignore=true)
    public UserAccount toEntity(UserAccountDTO dto);

    default UserAccount fromId(Long id){
        if (id == null) {
            return null;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setId(id);
        return userAccount;
    }      
}
