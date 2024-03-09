package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.Role;
import org.bshg.librarysystem.mySecurity.ws.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;

import java.util.List;

@Component
public class RoleConverter extends AbstractConverter<Role, RoleDto> {
    @Autowired @Lazy private UserConverter userConverter;
    @Autowired @Lazy private PermissionConverter permissionConverter;
    private boolean user = true;
    private boolean permission = true;

    @Override
    protected void convertersConfig(boolean value) {
        this.userConverter.setRole(value);
        this.permissionConverter.setRole(value);
    }

    @Override
    protected RoleDto convertToDto(Role item) {
        var dto = new RoleDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setUsers(user ? userConverter.toDto(item.getUsers()) : null);
        dto.setPermissions(permission ? permissionConverter.toDto(item.getPermissions()) : null);
        return dto;
    }

    @Override
    protected Role convertToItem(RoleDto dto) {
        var item = new Role();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setUsers(userConverter.toItem(dto.getUsers()));
        item.setPermissions(permissionConverter.toItem(dto.getPermissions()));
        return item;
    }

    public UserConverter getUserConverter() {
        return userConverter;
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public PermissionConverter getPermissionConverter() {
        return permissionConverter;
    }

    public void setPermissionConverter(PermissionConverter permissionConverter) {
        this.permissionConverter = permissionConverter;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
