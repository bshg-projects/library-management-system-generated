package org.bshg.librarysystem.services.user.admin.admin;

import org.bshg.librarysystem.entity.core.user.admin.Admin;

import java.util.List;

public interface AdminService {
    Admin findById(Long id);

    List<Admin> findAllOptimized();

    List<Admin> findAll();

    Admin create(Admin item);

    List<Admin> create(List<Admin> item);

    Admin update(Admin item);

    List<Admin> update(List<Admin> item);

    void deleteById(Long id);

    void delete(Admin item);

    void delete(List<Admin> items);

    void deleteByIdIn(List<Long> ids);
}