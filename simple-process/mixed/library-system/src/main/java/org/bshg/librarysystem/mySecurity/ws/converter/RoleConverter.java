package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.Role;
import org.bshg.librarysystem.mySecurity.ws.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleConverter {
    @Autowired
    @Lazy
    private UserConverter userConverter;
    @Autowired
    @Lazy
    private PermissionConverter permissionConverter;
    private boolean user = true;
    private boolean permission = true;

    protected void convertersConfig(boolean value) {
        this.userConverter.setRole(value);
        this.permissionConverter.setRole(value);
    }

    public final RoleDto toDto(Role item) {
        this.convertersConfig(false);
        if (item == null) return null;
        var dto = new RoleDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setUsers(user ? userConverter.toDto(item.getUsers()) : null);
        dto.setPermissions(permission ? permissionConverter.toDto(item.getPermissions()) : null);
        this.convertersConfig(true);
        return dto;
    }

    public final Role toItem(RoleDto dto) {
        if (dto == null) return null;
        var item = new Role();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setUsers(userConverter.toItem(dto.getUsers()));
        item.setPermissions(permissionConverter.toItem(dto.getPermissions()));
        return item;
    }

    public final List<Role> toItem(List<RoleDto> dtos) {
        List<Role> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<RoleDto> toDto(List<Role> items) {
        List<RoleDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
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
