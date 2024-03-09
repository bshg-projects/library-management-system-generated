package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum MagazinePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    MagazinePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "magazine";
    }

    @Override
    public String authority() {
        return value;
    }
}
