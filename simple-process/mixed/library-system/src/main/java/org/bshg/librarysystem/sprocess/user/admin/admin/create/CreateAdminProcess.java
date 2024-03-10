package org.bshg.librarysystem.sprocess.user.admin.admin.create;

import org.bshg.librarysystem.entity.core.user.admin.Admin;

import java.util.List;

public interface CreateAdminProcess {
    Admin run(Admin item);

    List<Admin> run(List<Admin> items);
}