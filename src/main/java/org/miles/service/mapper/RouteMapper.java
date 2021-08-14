package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.Route;
import org.miles.service.dto.RouteDTO;

@Mapper(componentModel = "cdi")
public interface RouteMapper extends EntityMapper<RouteDTO, Route>{

    @Override
    public RouteDTO toDto(Route entity);

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="state",ignore=true)
    public Route toEntity(RouteDTO dto);
    
    default Route fromId(Long id){
        if (id == null) {
            return null;
        }
        Route route = new Route();
        route.setId(id);
        return route;
    }
}
