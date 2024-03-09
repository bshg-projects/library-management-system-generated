package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum LibraryBranchPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    LibraryBranchPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "libraryBranch";
    }

    @Override
    public String authority() {
        return value;
    }
}
