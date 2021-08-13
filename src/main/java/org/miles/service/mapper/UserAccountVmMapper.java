package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.UserAccount;
import org.miles.service.dto.vm.UserAccountVM;

@Mapper(componentModel = "cdi")
public interface UserAccountVmMapper extends EntityMapper<UserAccountVM, UserAccount>{

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="status",ignore=true)
    @Mapping(target="secretKey",ignore=true)
    @Mapping(target="authorities",ignore=true)
    public UserAccount toEntity(UserAccountVM dto);    
}
