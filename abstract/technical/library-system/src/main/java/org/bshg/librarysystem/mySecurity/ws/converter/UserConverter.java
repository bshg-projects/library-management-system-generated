package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.User;
import org.bshg.librarysystem.mySecurity.ws.dto.UserDto;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<User, UserDto> {
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

    @Override
    protected void config() {
        this.dtoType = UserDto.class;
        this.itemType = User.class;
    }

    @Override
    protected void convertersConfig(boolean value) {
        this.roleConverter.setUser(value);
    }

    @Override
    protected UserDto convertToDto(User item) {
        var dto = new UserDto();
        dto.setId(item.getId());
        dto.setCredentialsNonExpired(item.isCredentialsNonExpired());
        dto.setEnabled(item.isEnabled());
        dto.setCreatedOn(item.getCreatedOn());
        dto.setUpdatedOn(item.getUpdatedOn());
        dto.setEmail(item.getEmail());
        dto.setAccountNonExpired(item.isAccountNonExpired());
        dto.setAccountNonLocked(item.isAccountNonLocked());
        dto.setUsername(item.getUsername());
        dto.setPasswordChanged(item.isPasswordChanged());
        dto.setRoles(role ? roleConverter.toDto(item.getRoles()) : null);
        return dto;
    }

    @Override
    protected User convertToItem(UserDto dto) {
        User item = new User();
        item.setId(dto.getId());
        item.setCredentialsNonExpired(dto.isCredentialsNonExpired());
        item.setEnabled(dto.isEnabled());
        item.setCreatedOn(dto.getCreatedOn());
        item.setUpdatedOn(dto.getUpdatedOn());
        item.setEmail(dto.getEmail());
        item.setAccountNonExpired(dto.isAccountNonExpired());
        item.setAccountNonLocked(dto.isAccountNonLocked());
        item.setUsername(dto.getUsername());
        item.setPasswordChanged(dto.isPasswordChanged());
        item.setRoles(roleConverter.toItem(dto.getRoles()));
        return item;
    }

    public <T extends User, DTO extends UserDto> void convertToChildDto(T childItem, DTO dto) {
        var userDto = toDto(childItem);
        dto.setId(userDto.getId());
        dto.setCredentialsNonExpired(userDto.isCredentialsNonExpired());
        dto.setEnabled(userDto.isEnabled());
        dto.setCreatedOn(userDto.getCreatedOn());
        dto.setUpdatedOn(userDto.getUpdatedOn());
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
