package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.GeneralUser;
import org.miles.service.dto.GeneralUserDTO;

@Mapper(componentModel = "cdi")
public interface GeneralUserMapper extends EntityMapper<GeneralUserDTO, GeneralUser>{

    @Override
    public GeneralUserDTO toDto(GeneralUser entity);

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="profilePicture",ignore=true)
    @Mapping(target="requests",ignore=true)
    @Mapping(target="ratings",ignore=true)
    @Mapping(target="userAccount",ignore=true)
    public GeneralUser toEntity(GeneralUserDTO dto);
    
    default GeneralUser fromId(Long id){
        if (id == null) {
            return null;
        }
        GeneralUser generalUser = new GeneralUser();
        generalUser.id = id;
        return generalUser;
    }
}
