package org.bshg.librarysystem.mySecurity.helper;

import java.io.Serial;
import java.io.Serializable;

public record AuthenticationResponse(String token) implements Serializable {
    @Serial
    private static final long serialVersionUID = -3119742936197757809L;
}
