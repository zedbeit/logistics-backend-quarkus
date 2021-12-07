package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.Company;
import org.miles.service.dto.CompanyDTO;

@Mapper(componentModel = "cdi")
public interface CompanyMapper extends EntityMapper<CompanyDTO, Company>{

    @Override
    public CompanyDTO toDto(Company entity);

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="id",ignore=true)
    @Mapping(target="cacDocument",ignore=true)
    @Mapping(target="requests",ignore=true)
    @Mapping(target="riders",ignore=true)
    @Mapping(target="ratings",ignore=true)
    @Mapping(target="vehicles",ignore=true)
    @Mapping(target="userAccount",ignore=true)
    @Mapping(target="states",ignore=true)
    public Company toEntity(CompanyDTO dto);
    
    default Company fromId(Long id){
        if (id == null) {
            return null;
        }
        Company company = new Company();
        company.id = id;
        return company;
    }
}
