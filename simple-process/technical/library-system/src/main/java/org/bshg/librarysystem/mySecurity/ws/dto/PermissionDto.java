package org.bshg.librarysystem.mySecurity.ws.dto;

import java.util.ArrayList;
import java.util.List;

public class PermissionDto {
    private String name;
    private Long id;
    List<RoleDto> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
