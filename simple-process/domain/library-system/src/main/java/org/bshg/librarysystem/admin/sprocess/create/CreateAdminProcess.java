package org.bshg.librarysystem.admin.sprocess.create;

import org.bshg.librarysystem.admin.Admin;

import java.util.List;

public interface CreateAdminProcess {
    Admin run(Admin item);

    List<Admin> run(List<Admin> items);
}