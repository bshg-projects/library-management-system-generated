package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    @Lazy
    private RoleConverter roleConverter;

    private boolean role = true;

    @Autowired
    public UserConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public UserConverter(RoleConverter roleConverter, boolean role) {
        this.roleConverter = roleConverter;
        this.role = role;
    }

    protected void convertersConfig(boolean value) {
        this.roleConverter.setUser(value);
    }

    public final UserDto toDto(User item) {
        if (item == null) return null;
        this.convertersConfig(false);
        var dto = new UserDto();
        dto.setId(item.getId());
        dto.setCredentialsNonExpired(item.isCredentialsNonExpired());
        dto.setEnabled(item.isEnabled());
        dto.setEmail(item.getEmail());
        dto.setAccountNonExpired(item.isAccountNonExpired());
        dto.setAccountNonLocked(item.isAccountNonLocked());
        dto.setUsername(item.getUsername());
        dto.setPasswordChanged(item.isPasswordChanged());
        dto.setRoles(role ? roleConverter.toDto(item.getRoles()) : null);
        this.convertersConfig(true);
        return dto;
    }

    public final User toItem(UserDto dto) {
        if (dto == null) return null;
        User item = new User();
        item.setId(dto.getId());
        item.setCredentialsNonExpired(dto.isCredentialsNonExpired());
        item.setEnabled(dto.isEnabled());
        item.setEmail(dto.getEmail());
        item.setAccountNonExpired(dto.isAccountNonExpired());
        item.setAccountNonLocked(dto.isAccountNonLocked());
        item.setUsername(dto.getUsername());
        item.setPasswordChanged(dto.isPasswordChanged());
        item.setRoles(roleConverter.toItem(dto.getRoles()));
        return item;
    }

    public final List<User> toItem(List<UserDto> dtos) {
        List<User> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<UserDto> toDto(List<User> items) {
        List<UserDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    public <T extends User, DTO extends UserDto> void convertToChildDto(T childItem, DTO dto) {
        var userDto = toDto(childItem);
        dto.setId(userDto.getId());
        dto.setCredentialsNonExpired(userDto.isCredentialsNonExpired());
        dto.setEnabled(userDto.isEnabled());
        dto.setEmail(userDto.getEmail());
        dto.setAccountNonExpired(userDto.isAccountNonExpired());
        dto.setAccountNonLocked(userDto.isAccountNonLocked());
        dto.setUsername(userDto.getUsername());
        dto.setPasswordChanged(userDto.isPasswordChanged());
        dto.setRoles(userDto.getRoles());
    }

    public <T extends User, DTO extends UserDto> void convertToChildItem(DTO childDto, T item) {
        User user = toItem(childDto);
        item.setId(user.getId());
        item.setCredentialsNonExpired(user.isCredentialsNonExpired());
        item.setEnabled(user.isEnabled());
        item.setCreatedOn(user.getCreatedOn());
        item.setUpdatedOn(user.getUpdatedOn());
        item.setEmail(user.getEmail());
        item.setAccountNonExpired(user.isAccountNonExpired());
        item.setAccountNonLocked(user.isAccountNonLocked());
        item.setUsername(user.getUsername());
        item.setPasswordChanged(user.isPasswordChanged());
        item.setRoles(user.getRoles());
    }

    public RoleConverter getRoleConverter() {
        return this.roleConverter;
    }

    public boolean isRole() {
        return this.role;
    }

    public void setRoleConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
