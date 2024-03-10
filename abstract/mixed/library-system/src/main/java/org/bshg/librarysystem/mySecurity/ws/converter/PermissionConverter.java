package org.bshg.librarysystem.mySecurity.ws.converter;

import org.bshg.librarysystem.mySecurity.entity.Permission;
import org.bshg.librarysystem.mySecurity.ws.dto.PermissionDto;
import org.bshg.librarysystem.utils.webservice.converter.AbstractConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PermissionConverter extends AbstractConverter<Permission, PermissionDto> {
    @Autowired
    @Lazy
    private RoleConverter roleConverter;
    private boolean role = true;

    @Override
    protected void config() {
        this.dtoType = PermissionDto.class;
        this.itemType = Permission.class;
    }

    @Override
    protected void convertersConfig(boolean value) {
        roleConverter.setPermission(value);
    }

    @Override
    public PermissionDto convertToDto(Permission item) {
        var dto = new PermissionDto();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setRoles(role ? roleConverter.toDto(item.getRoles()) : null);
        return dto;
    }

    @Override
    public Permission convertToItem(PermissionDto dto) {
        var item = new Permission();
        item.setId(dto.getId());
        item.setName(dto.getName());
        item.setRoles(role ? roleConverter.toItem(dto.getRoles()) : null);
        return item;
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
