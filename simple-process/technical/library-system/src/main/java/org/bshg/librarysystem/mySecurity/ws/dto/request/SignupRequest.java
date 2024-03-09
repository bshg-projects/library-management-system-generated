package org.bshg.librarysystem.mySecurity.ws.dto.request;

import java.util.Set;

public class SignupRequest {
private String username;
private String email;
private Set<String> role;
private String password;

public String getUsername() {
return this.username;
}

public String getEmail() {
return this.email;
}

public Set<String> getRole() {
return this.role;
}

public String getPassword() {
return this.password;
}

public void setUsername(String username) {
this.username = username;
}

public void setEmail(String email) {
this.email = email;
}

public void setRole(Set<String> role) {
this.role = role;
}

public void setPassword(String password) {
this.password = password;
}
}
