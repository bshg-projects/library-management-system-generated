package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum AuthorBookPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    AuthorBookPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "authorBook";
    }

    @Override
    public String authority() {
        return value;
    }
}
