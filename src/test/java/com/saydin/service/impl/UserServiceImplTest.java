package com.saydin.service.impl;

import com.saydin.dto.UserDto;
import com.saydin.entity.User;
import com.saydin.repo.UserRepository;
import com.saydin.service.impl.UserImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks //asıl test etmek istediğimiz class
    private UserImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testSave(){
        UserDto userDto=new UserDto();
        userDto.setFirstName("sdvsdvsdv");
        userDto.setLastName("dadacds");
        userDto.setUsername("ssddvsdv");
        userDto.setEmail("aascaca");
        User userMock = mock(User.class);

        when(userMock.getId());
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(userMock);

        UserDto result = userService.save(userDto);

        assertEquals(result.getFirstName(), userDto.getFirstName());
        assertEquals(result.getId(), 1L);
    }
}
