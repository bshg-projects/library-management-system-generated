package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum MembershipPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    MembershipPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "membership";
    }

    @Override
    public String authority() {
        return value;
    }
}
