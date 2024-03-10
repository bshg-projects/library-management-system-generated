package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum CountryPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    CountryPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "country";
    }

    @Override
    public String authority() {
        return value;
    }
}
