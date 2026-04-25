package com.codominator.usermicroservice.mapper;

import com.codominator.usermicroservice.dto.request.AddressDto;
import com.codominator.usermicroservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(target = "id", source = "id", ignore = true)
    Address addressDtoToAddressMapper(AddressDto addressDto);
    AddressDto addressToAddressResponseDto(Address address);
}
