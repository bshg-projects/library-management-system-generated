package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum StaffPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    StaffPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "staff";
    }

    @Override
    public String authority() {
        return value;
    }
}
