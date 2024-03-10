package org.bshg.librarysystem.mySecurity.permissions.resources;

import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum EmployeePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EmployeePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "employee";
    }

    @Override
    public String authority() {
        return value;
    }
}
