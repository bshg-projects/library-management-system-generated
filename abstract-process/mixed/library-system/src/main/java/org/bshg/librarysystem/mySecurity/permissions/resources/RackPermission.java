package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum RackPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    RackPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "rack";
    }

    @Override
    public String authority() {
        return value;
    }
}
