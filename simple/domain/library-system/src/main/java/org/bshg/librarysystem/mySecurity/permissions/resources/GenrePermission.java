package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum GenrePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    GenrePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "genre";
    }

    @Override
    public String authority() {
        return value;
    }
}
