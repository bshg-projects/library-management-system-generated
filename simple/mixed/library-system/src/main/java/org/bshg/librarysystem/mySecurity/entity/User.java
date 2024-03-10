package org.bshg.librarysystem.mySecurity.entity;

import jakarta.persistence.*;
import org.bshg.librarysystem.utils.entity.audit.AuditEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends AuditEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    protected String email;
    protected String username;
    protected String password;

    protected boolean credentialsNonExpired = true;
    protected boolean enabled = true;
    protected boolean accountNonExpired = true;
    protected boolean accountNonLocked = true;
    protected boolean passwordChanged = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")}
    )
    protected List<Role> roles = new ArrayList<>();
    @Transient
    protected List<Authority> authorities;

    public User() {
        super();
    }

    public User(String username) {
        this();
        this.username = username;
        this.password = username;
        this.email = username;
    }

    public User(String username, String password) {
        this(username);
        this.password = password;
    }

    @Override
    public List<Authority> getAuthorities() {
        return roles.stream().flatMap(role -> {
                    List<Authority> authorities1 = new ArrayList<>();
                    authorities1.add(new Authority(role.getName()));
                    authorities1.addAll(role.getPermissions().stream().map(permission -> new Authority(permission.getName())).toList());
                    return authorities1.stream();
                })
                .collect(Collectors.toList());
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
