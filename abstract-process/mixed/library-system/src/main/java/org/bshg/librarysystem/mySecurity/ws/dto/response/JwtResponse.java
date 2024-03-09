package org.bshg.librarysystem.mySecurity.ws.dto.response;

import java.util.List;

public class JwtResponse {
private String accessToken;
private String tokenType = "Bearer";
private Long id;
private String username;
private String email;
private List<String> roles;

public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
this.accessToken = accessToken;
this.id = id;
this.username = username;
this.email = email;
this.roles = roles;
}


public String getAccessToken() {
return this.accessToken;
}

public String getTokenType() {
return this.tokenType;
}

public Long getId() {
return this.id;
}

public String getUsername() {
return this.username;
}

public String getEmail() {
return this.email;
}

public List<String> getRoles() {
return this.roles;
}

public void setAccessToken(String accessToken) {
this.accessToken = accessToken;
}

public void setTokenType(String tokenType) {
this.tokenType = tokenType;
}

public void setId(Long id) {
this.id = id;
}

public void setUsername(String username) {
this.username = username;
}

public void setEmail(String email) {
this.email = email;
}

public void setRoles(List<String> roles) {
this.roles = roles;
}
}
