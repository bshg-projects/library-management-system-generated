package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum BookPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    BookPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "book";
    }

    @Override
    public String authority() {
        return value;
    }
}
