package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum ClientPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ClientPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "client";
    }

    @Override
    public String authority() {
        return value;
    }
}
