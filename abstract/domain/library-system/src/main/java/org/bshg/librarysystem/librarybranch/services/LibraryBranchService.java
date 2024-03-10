package org.bshg.librarysystem.librarybranch.services;

import org.bshg.librarysystem.librarybranch.LibraryBranch;
import org.bshg.librarysystem.utils.service.IService;

public interface LibraryBranchService extends IService<LibraryBranch> {
    int deleteByAddressId(Long id);

    LibraryBranch findByAddressId(Long id);
}