package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum BookGenrePermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    BookGenrePermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "bookGenre";
    }

    @Override
    public String authority() {
        return value;
    }
}
