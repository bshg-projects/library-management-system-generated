package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum ShelfPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ShelfPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "shelf";
    }

    @Override
    public String authority() {
        return value;
    }
}
