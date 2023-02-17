package com.saydin.service;

import com.saydin.dto.UserDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    UserDto update(String id, UserDto userDto);
    UserDto getById(String id);
    List<UserDto> findAll(Pageable pageable);
    boolean delete(String id);


}
