package com.saydin.service.impl;

import com.saydin.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplIntegrationTest {

    @Autowired
    private UserImpl userService;

    @Test
    public void testSave(){
        UserDto userDto=new UserDto();
        userDto.setFirstName("sdvsdvsdv");
        userDto.setLastName("dadacds");
        userDto.setUsername("ssddvsdv");
        userDto.setEmail("aascaca");

        UserDto result = userService.save(userDto);
        assertFalse(result.getId().isEmpty());
    }
}
