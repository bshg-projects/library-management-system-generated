package org.bshg.librarysystem.mySecurity.ws.dto;

import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleDto extends AuditBaseDto {
    private String name;
    private String label;

    private List<UserDto> users;

    private Set<PermissionDto> permissions = new HashSet<>();

    public RoleDto() {
    }

    public String getName() {
        return this.name;
    }

    public String getLabel() {
        return this.label;
    }

    public List<UserDto> getUsers() {
        return this.users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}
