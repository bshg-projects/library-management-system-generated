package org.bshg.librarysystem.mySecurity.permissions;

public interface PermissionResource {
    String create = "create";
    String read = "read";
    String edit = "edit";
    String delete = "delete";

    String authority();

    String resource();

    default String authority(String action) {
        return resource() + ":" + action;
    }
}
