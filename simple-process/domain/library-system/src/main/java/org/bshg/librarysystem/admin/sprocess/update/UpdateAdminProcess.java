package org.bshg.librarysystem.admin.sprocess.update;

import org.bshg.librarysystem.admin.Admin;

import java.util.List;

public interface UpdateAdminProcess {
    Admin run(Admin item);

    List<Admin> run(List<Admin> items);
}
