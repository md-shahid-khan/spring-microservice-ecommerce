package com.codominator.usermicroservice.mapper;

import com.codominator.usermicroservice.dto.request.UserRequestDto;
import com.codominator.usermicroservice.dto.response.UserResponseDto;
import com.codominator.usermicroservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface UserMapper {
    User mapUserRequestToUser(UserRequestDto userRequestDto);
    UserResponseDto mapUserTouserResponseDto(User user);
    void updateFromDtoToUser(UserRequestDto userRequestDto, @MappingTarget User user);

}
