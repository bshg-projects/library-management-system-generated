package org.bshg.librarysystem.mySecurity.service.impl;

import org.bshg.librarysystem.mySecurity.entity.Permission;
import org.bshg.librarysystem.mySecurity.dao.PermissionDao;
import org.bshg.librarysystem.mySecurity.service.facade.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission save(Permission permission) {
        Permission perm = permissionDao.findByName(permission.getName());
        return perm == null ? permissionDao.save(permission) : perm;
    }
}