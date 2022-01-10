package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.lang.entity.Trip;
import org.miles.service.dto.TripDTO;

@Mapper(componentModel = "cdi")
public interface TripMapper extends EntityMapper<TripDTO, Trip>{

    @Override
    public TripDTO toDto(Trip entity);

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="request",ignore=true)
    @Mapping(target="rider",ignore=true)
    public Trip toEntity(TripDTO dto);
    
    default Trip fromId(Long id){
        if (id == null) {
            return null;
        }
        Trip trip = new Trip();
        trip.setId(id);
        return trip;
    }
}
