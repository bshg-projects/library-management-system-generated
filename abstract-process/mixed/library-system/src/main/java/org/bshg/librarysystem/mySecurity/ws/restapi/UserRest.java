package org.bshg.librarysystem.mySecurity.ws.restapi;

import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.service.facade.UserService;
import org.bshg.librarysystem.mySecurity.ws.converter.UserConverter;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/users")
@RestController
public class UserRest {
    private final UserService userService;
    private final UserConverter userConverter;

    public UserRest(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping()
    public List<UserDto> findAll() {
        List<User> all = this.userService.findAll();
        return userConverter.toDto(all);
    }

    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/id/{id}")
    public UserDto findById(@PathVariable Long id) {
        User byId = userService.findById(id);
        return userConverter.toDto(byId);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto) {
        User user = userConverter.toItem(userDto);
        User saved = userService.save(user);
        return userConverter.toDto(saved);
    }

    @PutMapping()
    public UserDto update(@RequestBody UserDto userDto) {
        User user = userConverter.toItem(userDto);
        User saved = userService.update(user);
        return userConverter.toDto(saved);
    }

    @DeleteMapping()
    public int delete(@RequestBody UserDto userDto) {
        User user = userConverter.toItem(userDto);
        return userService.delete(user);
    }

    @GetMapping("/username/{username}")
    public UserDto findByUsernameWithRoles(@PathVariable String username) {
        return userConverter.toDto(userService.findByUsernameWithRoles(username));
    }

    @DeleteMapping("/username/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }
}

