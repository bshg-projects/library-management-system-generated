package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum LoanPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    LoanPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "loan";
    }

    @Override
    public String authority() {
        return value;
    }
}
