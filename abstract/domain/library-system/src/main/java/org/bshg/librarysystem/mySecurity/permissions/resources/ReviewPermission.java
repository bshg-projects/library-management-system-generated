package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum ReviewPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    ReviewPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "review";
    }

    @Override
    public String authority() {
        return value;
    }
}
