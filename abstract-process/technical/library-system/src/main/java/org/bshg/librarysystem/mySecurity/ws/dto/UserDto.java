package org.bshg.librarysystem.mySecurity.ws.dto;

import org.bshg.librarysystem.utils.webservice.dto.AuditBaseDto;

import java.util.ArrayList;
import java.util.List;

public class UserDto extends AuditBaseDto {
    protected boolean credentialsNonExpired = true;
    protected boolean enabled = true;
    protected String email;
    protected boolean accountNonExpired = true;
    protected boolean accountNonLocked = true;
    protected String username;
    protected boolean passwordChanged = false;
    protected List<RoleDto> roles = new ArrayList<>();

    public UserDto() {
    }

    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isPasswordChanged() {
        return this.passwordChanged;
    }

    public List<RoleDto> getRoles() {
        return this.roles;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }
}
