package com.IULP.BackEnd.Service;

import com.IULP.BackEnd.DTO.UserDto;
import com.IULP.BackEnd.Model.User;
import com.IULP.BackEnd.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public boolean join(UserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return userRepository.save(dto.toEntity()) != null;
    }

}