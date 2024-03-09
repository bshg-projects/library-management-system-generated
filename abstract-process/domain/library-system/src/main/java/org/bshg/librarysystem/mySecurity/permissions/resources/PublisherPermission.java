package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum PublisherPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    PublisherPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "publisher";
    }

    @Override
    public String authority() {
        return value;
    }
}
