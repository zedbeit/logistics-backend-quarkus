package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.lang.entity.Rider;
import org.miles.service.dto.RiderDTO;

@Mapper(componentModel = "cdi")
public interface RiderMapper extends EntityMapper<RiderDTO, Rider>{

    @Override
    public RiderDTO toDto(Rider entity);

    @Override
    @Mapping(target="trips",ignore=true)
    @Mapping(target="company",ignore=true)
    @Mapping(target="ratings",ignore=true)
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    public Rider toEntity(RiderDTO dto);
    
    default Rider fromId(Long id){
        if (id == null) {
            return null;
        }
        Rider rider = new Rider();
        rider.setId(id);
        return rider;
    }
}
