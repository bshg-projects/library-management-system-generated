package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.Permission;
import org.bshg.librarysystem.mySecurity.ws.dto.PermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissionConverter {
    @Autowired
    @Lazy
    private RoleConverter roleConverter;
    private boolean role = true;

    protected void convertersConfig(boolean value) {
        roleConverter.setPermission(value);
    }

    public final PermissionDto toDto(Permission item) {
        if (item == null) return null;
        this.convertersConfig(false);
        var dto = new PermissionDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setRoles(role ? roleConverter.toDto(item.getRoles()) : null);
        this.convertersConfig(true);
        return dto;
    }

    public final Permission toItem(PermissionDto dto) {
        if (dto == null) return null;
        var item = new Permission();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setRoles(role ? roleConverter.toItem(dto.getRoles()) : null);
        return item;
    }

    public final List<Permission> toItem(List<PermissionDto> dtos) {
        List<Permission> list = new ArrayList<>();
        dtos.forEach(it -> list.add(toItem(it)));
        return list;
    }

    public final List<PermissionDto> toDto(List<Permission> items) {
        List<PermissionDto> list = new ArrayList<>();
        items.forEach(it -> list.add(toDto(it)));
        return list;
    }

    public Set<PermissionDto> toDto(Set<Permission> roles) {
        if (roles == null) return null;
        return roles.stream().map(this::toDto).collect(Collectors.toSet());
    }

    public Set<Permission> toItem(Set<PermissionDto> roleDtos) {
        if (roleDtos == null) return null;
        return roleDtos.stream().map(this::toItem).collect(Collectors.toSet());
    }

    public RoleConverter getRoleConverter() {
        return roleConverter;
    }

    public void setRoleConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }
}
