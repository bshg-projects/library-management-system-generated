package org.bshg.librarysystem.sprocess.user.admin.admin.update;

import org.bshg.librarysystem.entity.core.user.admin.Admin;

import java.util.List;

public interface UpdateAdminProcess {
    Admin run(Admin item);

    List<Admin> run(List<Admin> items);
}
