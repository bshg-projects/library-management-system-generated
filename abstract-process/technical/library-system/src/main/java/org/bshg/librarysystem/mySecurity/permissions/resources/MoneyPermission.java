package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum MoneyPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    MoneyPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "money";
    }

    @Override
    public String authority() {
        return value;
    }
}
