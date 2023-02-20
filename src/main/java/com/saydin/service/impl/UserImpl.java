package com.saydin.service.impl;


import com.saydin.dto.UserDto;
import com.saydin.entity.User;
import com.saydin.repo.UserRepository;
import com.saydin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto save(UserDto orgUserDto) {
        orgUserDto.setId(UUID.randomUUID().toString());
        Assert.notNull(orgUserDto.getId(),"Id Setlenmedi");
        Assert.notNull(orgUserDto.getUsername(),"Username Bulunamadı");
        User user=repository.save(modelMapper.map(orgUserDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional
    public UserDto update(String id, UserDto userDto) {
        User user=repository.findById(id).orElseThrow(()->new IllegalArgumentException(" User Bulunamadi"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        repository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getById(String id) {
        User user= repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> findAll(Pageable pageable) {
        return  repository.findAll(pageable)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean delete(String id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Organizasyon Bulunmadi")));
        return true;
    }


}
