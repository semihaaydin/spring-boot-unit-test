package com.saydin.api;

import com.saydin.dto.UserDto;
import com.saydin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(Pageable pageable){
       return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto organizationDto){
         return ResponseEntity.ok(service.save(organizationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update( @PathVariable("id") String id,  @RequestBody UserDto organizationDto){
        return ResponseEntity.ok(service.update(id,organizationDto));
    }

    @DeleteMapping("/{id}")
    public boolean delete( @PathVariable("id") String id){
        return service.delete(id);
    }
}
