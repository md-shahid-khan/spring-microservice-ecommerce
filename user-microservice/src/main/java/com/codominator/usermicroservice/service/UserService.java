package com.codominator.usermicroservice.service;

import com.codominator.usermicroservice.dto.request.UserRequestDto;
import com.codominator.usermicroservice.dto.response.UserResponseDto;
import com.codominator.usermicroservice.entity.User;
import com.codominator.usermicroservice.mapper.UserMapper;
import com.codominator.usermicroservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::mapUserTouserResponseDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = userMapper.mapUserRequestToUser(userRequestDto);


        User savedUser = userRepository.save(user);

        return userMapper.mapUserTouserResponseDto(savedUser);
    }

    public UserResponseDto findUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserTouserResponseDto)
                .orElseThrow(()-> new IllegalArgumentException("User not found with id " + id));
    }

    public Optional<UserResponseDto> updateUser(Long id, UserRequestDto userRequestDto) {
        return userRepository.findById(id).map(existingUser -> {
            userMapper.updateFromDtoToUser(userRequestDto, existingUser);
            User savedUser = userRepository.save(existingUser);
            return userMapper.mapUserTouserResponseDto(savedUser);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}