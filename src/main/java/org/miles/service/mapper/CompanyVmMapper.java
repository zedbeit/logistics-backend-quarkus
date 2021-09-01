package org.miles.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.miles.domain.Company;
import org.miles.service.dto.vm.CompanyVM;

@Mapper(componentModel = "cdi")
public interface CompanyVmMapper extends EntityMapper<CompanyVM, Company>{

    @Override
    @Mapping(target="createdDate",ignore=true)
    @Mapping(target="lastModifiedDate",ignore=true)
    @Mapping(target="cacDocument",ignore=true)
    @Mapping(target="requests",ignore=true)
    @Mapping(target="riders",ignore=true)
    @Mapping(target="ratings",ignore=true)
    @Mapping(target="vehicles",ignore=true)
    @Mapping(target="companyAddress",ignore=true)
    @Mapping(target="companyPhoneNumber",ignore=true)
    @Mapping(target="pricePerKm",ignore=true)
    @Mapping(target="bvnNumber",ignore=true)
    @Mapping(target="states",ignore=true)
    public Company toEntity(CompanyVM dto);    
}
