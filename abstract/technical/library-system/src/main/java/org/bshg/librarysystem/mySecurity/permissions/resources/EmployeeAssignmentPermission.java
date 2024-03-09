package org.bshg.librarysystem.mySecurity.permissions.resources;
import org.bshg.librarysystem.mySecurity.permissions.PermissionResource;

public enum EmployeeAssignmentPermission implements PermissionResource {
    CREATE(create),
    READ(read),
    EDIT(edit),
    DELETE(delete),
    ;

    private final String value;

    EmployeeAssignmentPermission(String action) {
        this.value = authority(action);
    }

    @Override
    public String resource() {
        return "employeeAssignment";
    }

    @Override
    public String authority() {
        return value;
    }
}
