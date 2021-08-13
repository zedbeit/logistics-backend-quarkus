package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.Request;
import org.miles.service.dto.RequestDTO;

@Mapper(componentModel = "cdi")
public interface RequestMapper extends EntityMapper<RequestDTO, Request>{

    @Override
    public RequestDTO toDto(Request entity);

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="company",ignore=true)
    @Mapping(target="generalUser",ignore=true)
    @Mapping(target="trip",ignore=true)
    @Mapping(target="payment",ignore=true)
    public Request toEntity(RequestDTO dto);
    
    default Request fromId(Long id){
        if (id == null) {
            return null;
        }
        Request request = new Request();
        request.setId(id);
        return request;
    }
}
